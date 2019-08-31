package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragmentBindModule
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeListItem_Factory_Factory
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeViewModel
import javax.inject.Provider

class HomeFragmentAndroidInjectorProvider(
    textRepository: Provider<TextRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    private val homeViewModelProvider =
        Provider {
            HomeViewModel(textRepository.get(), HomeListItem_Factory_Factory.create().get())
        }

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<HomeFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    HomeFragmentBindModule.provideViewModel(
                        instance,
                        ViewModelFactory(homeViewModelProvider)
                    )
            }
        }
}
