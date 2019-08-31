package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment

@Module(subcomponents = [MenuBottomSheetDialogFragmentModuleContributeMenuBottomSheetDialogFragment.Subcomponent::class])
abstract class MenuBottomSheetDialogFragmentModuleContributeMenuBottomSheetDialogFragment {

    @Binds
    @IntoMap
    @ClassKey(MenuBottomSheetDialogFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: Subcomponent.Factory): AndroidInjector.Factory<*>

    @dagger.Subcomponent
    interface Subcomponent : AndroidInjector<MenuBottomSheetDialogFragment> {
        @dagger.Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<MenuBottomSheetDialogFragment>
    }

}
