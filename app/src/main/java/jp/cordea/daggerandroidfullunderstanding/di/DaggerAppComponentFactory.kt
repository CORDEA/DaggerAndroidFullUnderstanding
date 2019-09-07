package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.App

class DaggerAppComponentFactory : AndroidInjector.Factory<App> {
    override fun create(instance: App?): AndroidInjector<App> = MyDaggerAppComponent()
}
