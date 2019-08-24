package jp.cordea.daggerandroidfullunderstanding.ui.add

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AddBottomSheetDialogFragmentModule {
    @ContributesAndroidInjector
    fun contributeAddBottomSheetDialogFragment(): AddBottomSheetDialogFragment
}
