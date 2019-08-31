package jp.cordea.daggerandroidfullunderstanding.di.injector

import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

class MyDispatchingAndroidInjector<T : Any> @Inject constructor(
    injectorFactoriesWithClassKeys: Map<Class<*>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<*>>>,
    injectorFactoriesWithStringKeys: Map<String, @JvmSuppressWildcards Provider<AndroidInjector.Factory<*>>>
) : AndroidInjector<T> {
    private val injectorFactories: Map<String, Provider<AndroidInjector.Factory<*>>> =
        injectorFactoriesWithClassKeys.mapKeys { it.key.name } + injectorFactoriesWithStringKeys

    override fun inject(instance: T) {
        val provider = injectorFactories.getValue(instance::class.java.name)
        @Suppress("UNCHECKED_CAST")
        (provider.get() as AndroidInjector.Factory<T>).create(instance).inject(instance)
    }
}
