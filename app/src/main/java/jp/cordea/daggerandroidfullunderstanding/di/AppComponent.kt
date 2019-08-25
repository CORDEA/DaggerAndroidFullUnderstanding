package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.cordea.daggerandroidfullunderstanding.ActivityModule
import jp.cordea.daggerandroidfullunderstanding.App
import jp.cordea.daggerandroidfullunderstanding.infra.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        RepositoryModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}
