package jp.cordea.daggerandroidfullunderstanding.di

import androidx.fragment.app.createViewModelLazy
import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeListItem
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeViewModel
import javax.inject.Provider

class HomeFragmentAndroidInjectorProvider(
    textRepository: Provider<TextRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    private val homeViewModelProvider =
        Provider {
            HomeViewModel(textRepository.get(), HomeListItem.Factory())
        }

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<HomeFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    instance.createViewModelLazy(
                        HomeViewModel::class,
                        { instance.viewModelStore },
                        { ViewModelFactory(homeViewModelProvider) }
                    )
            }
        }
}
