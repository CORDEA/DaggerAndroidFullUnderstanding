package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment

class MenuBottomSheetDialogFragmentSubcomponentFactory :
    MenuBottomSheetDialogFragmentModuleContributeMenuBottomSheetDialogFragment.Subcomponent.Factory {
    override fun create(instance: MenuBottomSheetDialogFragment?): AndroidInjector<MenuBottomSheetDialogFragment> =
        MenuBottomSheetDialogFragmentSubcomponentImpl()
}
