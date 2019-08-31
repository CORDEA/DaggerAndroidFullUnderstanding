package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment
import javax.inject.Provider

class MenuBottomSheetDialogFragmentAndroidInjectorProvider : Provider<AndroidInjector.Factory<*>> {
    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<MenuBottomSheetDialogFragment> { AndroidInjector { } }
}
