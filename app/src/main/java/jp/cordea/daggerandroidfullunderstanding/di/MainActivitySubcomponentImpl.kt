package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.MainActivity_MembersInjector
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment
import javax.inject.Provider

class MainActivitySubcomponentImpl(
    textRepository: Provider<TextRepositoryImpl>,
    tagRepository: Provider<TagRepositoryImpl>,
    private val mainActivitySubcomponentFactoryProvider: Provider<MainActivityModuleContributeMainActivity.Subcomponent.Factory>
) : MainActivityModuleContributeMainActivity.Subcomponent {
    private val menuBottomSheetDialogFragmentAndroidInjectorProvider =
        MenuBottomSheetDialogFragmentAndroidInjectorProvider()
    private val homeFragmentAndroidInjectorProvider =
        HomeFragmentAndroidInjectorProvider(textRepository)
    private val addBottomSheetDialogFragmentAndroidInjectorProvider =
        AddBottomSheetDialogFragmentAndroidInjectorProvider(textRepository)
    private val createTagFragmentAndroidInjectorProvider =
        CreateTagFragmentAndroidInjectorProvider(tagRepository)
    private val editTagFragmentAndroidInjectorProvider =
        EditTagFragmentAndroidInjectorProvider(tagRepository)

    override fun inject(instance: MainActivity?) {
        @Suppress("UNCHECKED_CAST")
        MainActivity_MembersInjector.injectDispatchingAndroidInjector(
            instance,
            DispatchingAndroidInjector_Factory.newInstance(
                mapOf<Class<*>, Provider<AndroidInjector.Factory<*>>>(
                    MainActivity::class.java to mainActivitySubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>,
                    HomeFragment::class.java to homeFragmentAndroidInjectorProvider as Provider<AndroidInjector.Factory<*>>,
                    CreateTagFragment::class.java to createTagFragmentAndroidInjectorProvider as Provider<AndroidInjector.Factory<*>>,
                    EditTagFragment::class.java to editTagFragmentAndroidInjectorProvider as Provider<AndroidInjector.Factory<*>>,
                    AddBottomSheetDialogFragment::class.java to addBottomSheetDialogFragmentAndroidInjectorProvider as Provider<AndroidInjector.Factory<*>>,
                    MenuBottomSheetDialogFragment::class.java to menuBottomSheetDialogFragmentAndroidInjectorProvider
                ),
                emptyMap()
            )
        )
    }
}
