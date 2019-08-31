package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment

@Module
class MenuBottomSheetDialogFragmentProvideModule {
    @Provides
    @IntoMap
    @ClassKey(MenuBottomSheetDialogFragment::class)
    fun provideAndroidInjectorFactory(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<MenuBottomSheetDialogFragment> { AndroidInjector { } }
}
