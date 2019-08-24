package jp.cordea.daggerandroidfullunderstanding.ui.menu

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MenuBottomSheetDialogFragmentModule {
    @ContributesAndroidInjector
    fun contributeMenuBottomSheetDialogFragment(): MenuBottomSheetDialogFragment
}
