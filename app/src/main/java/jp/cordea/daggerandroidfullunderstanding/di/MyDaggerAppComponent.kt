package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import dagger.internal.DoubleCheck
import jp.cordea.daggerandroidfullunderstanding.App
import jp.cordea.daggerandroidfullunderstanding.App_MembersInjector
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.*
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextDao_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextLocalDataSource_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRemoteDataSource_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl_Factory
import javax.inject.Provider

class MyDaggerAppComponent : AppComponent {
    private val textDaoProvider = DoubleCheck.provider(TextDao_Factory.create())
    private val tagDaoProvider = DoubleCheck.provider(TagDao_Factory.create())
    private val apiClientProvider = DoubleCheck.provider(ApiClient_Factory.create())

    private val textLocalDataSourceProvider =
        DoubleCheck.provider(TextLocalDataSource_Factory.create(textDaoProvider))
    private val textRemoteDataSourceProvider =
        DoubleCheck.provider(TextRemoteDataSource_Factory.create(apiClientProvider))
    private val textRepositoryImplProvider = DoubleCheck.provider(
        TextRepositoryImpl_Factory.create(
            textLocalDataSourceProvider,
            textRemoteDataSourceProvider
        )
    )

    private val tagLocalDataSourceProvider: Provider<TagLocalDataSource> =
        DoubleCheck.provider(TagLocalDataSource_Factory.create(tagDaoProvider))
    private val tagRemoteDataSourceProvider: Provider<TagRemoteDataSource> =
        DoubleCheck.provider(TagRemoteDataSource_Factory.create(apiClientProvider))
    private val tagRepositoryImplProvider: Provider<TagRepositoryImpl> =
        DoubleCheck.provider(
            TagRepositoryImpl_Factory.create(
                tagLocalDataSourceProvider,
                tagRemoteDataSourceProvider
            )
        )

    private val mainActivitySubcomponentFactoryProvider =
        MainActivityAndroidInjectorProvider(textRepositoryImplProvider, tagRepositoryImplProvider)

    @Suppress("UNCHECKED_CAST")
    override fun inject(instance: App?) =
        App_MembersInjector.injectDispatchingAndroidInjector(
            instance,
            DispatchingAndroidInjector_Factory.newInstance(
                mapOf<Class<*>, Provider<AndroidInjector.Factory<*>>>(
                    MainActivity::class.java to mainActivitySubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>
                ),
                emptyMap()
            )
        )
}
