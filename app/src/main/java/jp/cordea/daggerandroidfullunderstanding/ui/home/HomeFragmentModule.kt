package jp.cordea.daggerandroidfullunderstanding.ui.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface HomeFragmentModule {
    @ContributesAndroidInjector
    fun contributeHomeFragment(): HomeFragment
}
