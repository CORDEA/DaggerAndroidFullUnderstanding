package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory

@Module
interface EditTagFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            EditTagFragmentBindModule::class
        ]
    )
    fun contributeEditTagFragment(): EditTagFragment
}

@Module
abstract class EditTagFragmentBindModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideViewModel(
            fragment: Fragment,
            factory: ViewModelFactory<EditTagViewModel>
        ): Lazy<EditTagViewModel> =
            fragment.createViewModelLazy(
                EditTagViewModel::class,
                { fragment.viewModelStore },
                { factory }
            )
    }

    @Binds
    abstract fun bindFragment(fragment: EditTagFragment): Fragment
}
