package jp.cordea.daggerandroidfullunderstanding.ui.createtag

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CreateTagFragmentModule {
    @ContributesAndroidInjector
    fun contributeCreateTagFragment(): CreateTagFragment

}
