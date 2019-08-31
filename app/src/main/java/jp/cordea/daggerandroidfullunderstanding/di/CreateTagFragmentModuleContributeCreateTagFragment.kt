package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragmentBindModule

@Module(subcomponents = [CreateTagFragmentModuleContributeCreateTagFragment.Subcomponent::class])
abstract class CreateTagFragmentModuleContributeCreateTagFragment {

    @Binds
    @IntoMap
    @ClassKey(CreateTagFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: Subcomponent.Factory): AndroidInjector.Factory<*>

    @dagger.Subcomponent(modules = [CreateTagFragmentBindModule::class])
    interface Subcomponent : AndroidInjector<CreateTagFragment> {
        @dagger.Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<CreateTagFragment>
    }
}
