package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragmentModule_ContributeHomeFragment
import javax.inject.Provider

class HomeFragmentSubcomponentFactory(
    private val textRepository: Provider<TextRepositoryImpl>
) : HomeFragmentModule_ContributeHomeFragment.HomeFragmentSubcomponent.Factory {
    override fun create(instance: HomeFragment?): AndroidInjector<HomeFragment> =
        HomeFragmentSubcomponentImpl(instance!!, textRepository)
}
