package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentBindModule

@Module(subcomponents = [AddBottomSheetDialogFragmentModuleContributeAddBottomSheetDialogFragment.Subcomponent::class])
abstract class AddBottomSheetDialogFragmentModuleContributeAddBottomSheetDialogFragment {

    @Binds
    @IntoMap
    @ClassKey(AddBottomSheetDialogFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: Subcomponent.Factory): AndroidInjector.Factory<*>

    @dagger.Subcomponent(modules = [AddBottomSheetDialogFragmentBindModule::class])
    interface Subcomponent : AndroidInjector<AddBottomSheetDialogFragment> {
        @dagger.Subcomponent.Factory
        interface Factory : AndroidInjector<AddBottomSheetDialogFragment>
    }
}
