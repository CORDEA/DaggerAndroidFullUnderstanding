package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.*
import javax.inject.Provider

class HomeFragmentSubcomponentImpl(
    private val fragment: HomeFragment,
    textRepository: Provider<TextRepositoryImpl>
) : HomeFragmentModule_ContributeHomeFragment.HomeFragmentSubcomponent {
    @Suppress("UNCHECKED_CAST")
    private val homeViewModelProvider =
        HomeViewModel_Factory.create(
            textRepository as Provider<TextRepository>,
            HomeListItem_Factory_Factory.create()
        )

    override fun inject(instance: HomeFragment?) {
        HomeFragment_MembersInjector.injectViewModel(
            instance,
            HomeFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                fragment,
                ViewModelFactory_Factory.newInstance(homeViewModelProvider)
            )
        )
    }
}
