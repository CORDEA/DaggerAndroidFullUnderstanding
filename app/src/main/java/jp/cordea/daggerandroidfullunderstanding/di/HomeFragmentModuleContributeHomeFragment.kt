package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment

@Module(subcomponents = [HomeFragmentModuleContributeHomeFragment.Subcomponent::class])
abstract class HomeFragmentModuleContributeHomeFragment {

    @Binds
    @IntoMap
    @ClassKey(HomeFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: Subcomponent.Factory): AndroidInjector.Factory<*>

    @dagger.Subcomponent
    interface Subcomponent : AndroidInjector<HomeFragment> {
        @dagger.Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<HomeFragment>
    }
}
