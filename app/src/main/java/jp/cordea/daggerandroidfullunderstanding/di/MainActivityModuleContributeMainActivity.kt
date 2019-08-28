package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragmentModule
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragmentModule

@Module(subcomponents = [MainActivityModuleContributeMainActivity.Subcomponent::class])
interface MainActivityModuleContributeMainActivity {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    fun bindAndroidInjectorFactory(factory: Subcomponent.Factory): AndroidInjector.Factory<*>

    @dagger.Subcomponent(
        modules = [
            HomeFragmentModule::class,
            CreateTagFragmentModule::class,
            EditTagFragmentModule::class,
            AddBottomSheetDialogFragmentModule::class,
            MenuBottomSheetDialogFragmentModule::class
        ]
    )
    interface Subcomponent : AndroidInjector<MainActivity> {
        @dagger.Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<MainActivity>
    }
}
