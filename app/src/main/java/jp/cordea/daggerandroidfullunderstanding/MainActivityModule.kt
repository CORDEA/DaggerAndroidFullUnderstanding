package jp.cordea.daggerandroidfullunderstanding

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragmentModule

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentModule::class,
            CreateTagFragmentModule::class,
            EditTagFragmentModule::class,
            AddBottomSheetDialogFragmentModule::class,
            MenuBottomSheetDialogFragmentModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}
