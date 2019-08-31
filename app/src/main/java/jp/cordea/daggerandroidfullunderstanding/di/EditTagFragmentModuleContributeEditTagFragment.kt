package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragmentBindModule
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment

@Module(subcomponents = [EditTagFragmentModuleContributeEditTagFragment.Subcomponent::class])
abstract class EditTagFragmentModuleContributeEditTagFragment {

    @Binds
    @IntoMap
    @ClassKey(EditTagFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: Subcomponent.Factory): AndroidInjector.Factory<*>

    @dagger.Subcomponent(modules = [CreateTagFragmentBindModule::class])
    interface Subcomponent : AndroidInjector<EditTagFragment> {
        @dagger.Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<EditTagFragment>
    }
}
