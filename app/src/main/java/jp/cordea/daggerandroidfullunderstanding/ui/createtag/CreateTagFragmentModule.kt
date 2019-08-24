package jp.cordea.daggerandroidfullunderstanding.ui.createtag

import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory

@Module
interface CreateTagFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            CreateTagFragmentBindModule::class
        ]
    )
    fun contributeCreateTagFragment(): CreateTagFragment

}

@Module
abstract class CreateTagFragmentBindModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideViewModel(
            fragment: Fragment,
            factory: ViewModelFactory<CreateTagViewModel>
        ): Lazy<CreateTagViewModel> =
            fragment.createViewModelLazy(
                CreateTagViewModel::class,
                { fragment.viewModelStore },
                { factory }
            )
    }

    @Binds
    abstract fun bindFragment(fragment: CreateTagFragment): Fragment
}
