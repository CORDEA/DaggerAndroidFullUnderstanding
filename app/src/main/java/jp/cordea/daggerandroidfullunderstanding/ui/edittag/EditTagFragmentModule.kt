package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface EditTagFragmentModule {
    @ContributesAndroidInjector
    fun contributeEditTagFragment(): EditTagFragment
}
