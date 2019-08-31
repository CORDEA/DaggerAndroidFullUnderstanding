package jp.cordea.daggerandroidfullunderstanding

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.di.DaggerAppComponentFactory
import jp.cordea.daggerandroidfullunderstanding.di.injector.MyDispatchingAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: MyDispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
