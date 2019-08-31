package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragmentBindModule
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeListItem_Factory_Factory
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeViewModel_Factory
import javax.inject.Provider

class HomeFragmentAndroidInjectorProvider(
    textRepository: Provider<TextRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {

    @Suppress("UNCHECKED_CAST")
    private val homeViewModelProvider =
        HomeViewModel_Factory.create(
            textRepository as Provider<TextRepository>,
            HomeListItem_Factory_Factory.create()
        )

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<HomeFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    HomeFragmentBindModule.provideViewModel(
                        instance,
                        ViewModelFactory_Factory.newInstance(homeViewModelProvider)
                    )
            }
        }
}
