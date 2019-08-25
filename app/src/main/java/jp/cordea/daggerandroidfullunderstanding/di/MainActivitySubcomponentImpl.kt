package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.MainActivityModule_ContributeMainActivity
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
    private val textRepository: Provider<TextRepositoryImpl>,
    private val tagRepository: Provider<TagRepositoryImpl>,
    private val mainActivitySubcomponentFactoryProvider: Provider<MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Factory>
) : MainActivityModule_ContributeMainActivity.MainActivitySubcomponent {
    private val homeFragmentSubcomponentFactoryProvider =
        Provider { HomeFragmentSubcomponentFactory(textRepository) }
    private val createTagFragmentSubcomponentFactoryProvider =
        Provider { CreateTagFragmentSubcomponentFactory(tagRepository) }
    private val editTagFragmentSubcomponentFactoryProvider =
        Provider { EditTagFragmentSubcomponentFactory(tagRepository) }
    private val addBottomSheetDialogFragmentSubcomponentFactoryProvider =
        Provider { AddBottomSheetDialogFragmentSubcomponentFactory(textRepository) }
    private val menuBottomSheetDialogFragmentSubcomponentFactoryProvider =
        Provider { MenuBottomSheetDialogFragmentSubcomponentFactory() }


    override fun inject(instance: MainActivity?) {
        @Suppress("UNCHECKED_CAST")
        MainActivity_MembersInjector.injectDispatchingAndroidInjector(
            instance,
            DispatchingAndroidInjector_Factory.newInstance(
                mapOf<Class<*>, Provider<AndroidInjector.Factory<*>>>(
                    MainActivity::class.java to mainActivitySubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>,
                    HomeFragment::class.java to homeFragmentSubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>,
                    CreateTagFragment::class.java to createTagFragmentSubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>,
                    EditTagFragment::class.java to editTagFragmentSubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>,
                    AddBottomSheetDialogFragment::class.java to addBottomSheetDialogFragmentSubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>,
                    MenuBottomSheetDialogFragment::class.java to menuBottomSheetDialogFragmentSubcomponentFactoryProvider as Provider<AndroidInjector.Factory<*>>
                ),
                emptyMap()
            )
        )
    }
}
