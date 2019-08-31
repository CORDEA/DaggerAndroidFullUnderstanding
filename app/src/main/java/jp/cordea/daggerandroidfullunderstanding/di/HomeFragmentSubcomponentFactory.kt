package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import javax.inject.Provider

class HomeFragmentSubcomponentFactory(
    private val textRepository: Provider<TextRepositoryImpl>
) : HomeFragmentModuleContributeHomeFragment.Subcomponent.Factory {
    override fun create(instance: HomeFragment?): AndroidInjector<HomeFragment> =
        HomeFragmentSubcomponentImpl(instance!!, textRepository)
}
