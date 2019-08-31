package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import dagger.internal.DoubleCheck
import jp.cordea.daggerandroidfullunderstanding.App
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagDao
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagLocalDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRemoteDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextDao
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextLocalDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRemoteDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import javax.inject.Provider

class MyDaggerAppComponent : AppComponent {
    private val textDaoProvider = DoubleCheck.provider(Provider { TextDao() })
    private val tagDaoProvider = DoubleCheck.provider(Provider { TagDao() })
    private val apiClientProvider = DoubleCheck.provider(Provider { ApiClient() })

    private val textLocalDataSourceProvider =
        DoubleCheck.provider(Provider { TextLocalDataSource(textDaoProvider.get()) })
    private val textRemoteDataSourceProvider =
        DoubleCheck.provider(Provider { TextRemoteDataSource(apiClientProvider.get()) })
    private val textRepositoryImplProvider = DoubleCheck.provider(
        Provider {
            TextRepositoryImpl(
                textLocalDataSourceProvider.get(),
                textRemoteDataSourceProvider.get()
            )
        }
    )

    private val tagLocalDataSourceProvider: Provider<TagLocalDataSource> =
        DoubleCheck.provider(Provider { TagLocalDataSource(tagDaoProvider.get()) })
    private val tagRemoteDataSourceProvider: Provider<TagRemoteDataSource> =
        DoubleCheck.provider(Provider { TagRemoteDataSource(apiClientProvider.get()) })
    private val tagRepositoryImplProvider: Provider<TagRepositoryImpl> =
        DoubleCheck.provider(
            Provider {
                TagRepositoryImpl(
                    tagLocalDataSourceProvider.get(),
                    tagRemoteDataSourceProvider.get()
                )
            }
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
