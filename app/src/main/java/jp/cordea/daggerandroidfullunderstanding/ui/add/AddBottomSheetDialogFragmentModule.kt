package jp.cordea.daggerandroidfullunderstanding.ui.add

import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory

@Module
interface AddBottomSheetDialogFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            AddBottomSheetDialogFragmentBindModule::class
        ]
    )
    fun contributeAddBottomSheetDialogFragment(): AddBottomSheetDialogFragment
}

@Module
abstract class AddBottomSheetDialogFragmentBindModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideViewModel(
            fragment: Fragment,
            factory: ViewModelFactory<AddViewModel>
        ): Lazy<AddViewModel> =
            fragment.createViewModelLazy(
                AddViewModel::class,
                { fragment.viewModelStore },
                { factory }
            )
    }

    @Binds
    abstract fun bindFragment(fragment: AddBottomSheetDialogFragment): Fragment
}
