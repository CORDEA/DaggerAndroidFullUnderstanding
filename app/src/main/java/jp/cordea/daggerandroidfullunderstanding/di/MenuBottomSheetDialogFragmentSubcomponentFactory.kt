package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragmentModule_ContributeMenuBottomSheetDialogFragment

class MenuBottomSheetDialogFragmentSubcomponentFactory :
    MenuBottomSheetDialogFragmentModule_ContributeMenuBottomSheetDialogFragment.MenuBottomSheetDialogFragmentSubcomponent.Factory {
    override fun create(instance: MenuBottomSheetDialogFragment?): AndroidInjector<MenuBottomSheetDialogFragment> =
        MenuBottomSheetDialogFragmentSubcomponentImpl()
}
