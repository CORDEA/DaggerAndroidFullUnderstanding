package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.App

class DaggerAppComponentFactory : AppComponent.Factory {
    override fun create(instance: App?): AndroidInjector<App> = MyDaggerAppComponent()
}
