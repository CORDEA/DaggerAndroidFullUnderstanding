package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import dagger.internal.DoubleCheck
import jp.cordea.daggerandroidfullunderstanding.App
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagLocalDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRemoteDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import javax.inject.Provider

class MyDaggerAppComponent : AppComponent {
    private val textDaoProvider = DoubleCheck.provider(TextDaoProvider)
    private val tagDaoProvider = DoubleCheck.provider(TagDaoProvider)
    private val apiClientProvider = DoubleCheck.provider(ApiClientProvider)

    private val textLocalDataSourceProvider =
        DoubleCheck.provider(TextLocalDataSourceProvider(textDaoProvider))
    private val textRemoteDataSourceProvider =
        DoubleCheck.provider(TextRemoteDataSourceProvider(apiClientProvider))
    private val textRepositoryImplProvider = DoubleCheck.provider(
        TextRepositoryImplProvider(
            textRemoteDataSourceProvider,
            textLocalDataSourceProvider
        )
    )

    private val tagLocalDataSourceProvider: Provider<TagLocalDataSource> =
        DoubleCheck.provider(TagLocalDataSourceProvider(tagDaoProvider))
    private val tagRemoteDataSourceProvider: Provider<TagRemoteDataSource> =
        DoubleCheck.provider(TagRemoteDataSourceProvider(apiClientProvider))
    private val tagRepositoryImplProvider: Provider<TagRepositoryImpl> =
        DoubleCheck.provider(
            TagRepositoryImplProvider(
                tagRemoteDataSourceProvider,
                tagLocalDataSourceProvider
            )
        )

    private val mainActivitySubcomponentFactoryProvider =
        MainActivityAndroidInjectorProvider(textRepositoryImplProvider, tagRepositoryImplProvider)

    @Suppress("UNCHECKED_CAST")
    override fun inject(instance: App?) {
        instance!!.dispatchingAndroidInjector =
            DispatchingAndroidInjector_Factory.newInstance(
                mapOf<Class<*>, Provider<AndroidInjector.Factory<*>>>(
                    MainActivity::class.java to mainActivitySubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>
                ),
                emptyMap()
            )
    }
}
