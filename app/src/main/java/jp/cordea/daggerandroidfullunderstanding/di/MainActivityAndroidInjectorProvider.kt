package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.di.injector.MyDispatchingAndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.home.HomeFragment
import jp.cordea.daggerandroidfullunderstanding.ui.menu.MenuBottomSheetDialogFragment
import javax.inject.Provider

class MainActivityAndroidInjectorProvider(
    textRepository: Provider<TextRepositoryImpl>,
    tagRepository: Provider<TagRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
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

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<MainActivity> {
            AndroidInjector { instance ->
                instance!!.dispatchingAndroidInjector =
                    MyDispatchingAndroidInjector(
                        mapOf(
                            MainActivity::class.java to this,
                            HomeFragment::class.java to homeFragmentAndroidInjectorProvider,
                            CreateTagFragment::class.java to createTagFragmentAndroidInjectorProvider,
                            EditTagFragment::class.java to editTagFragmentAndroidInjectorProvider,
                            AddBottomSheetDialogFragment::class.java to addBottomSheetDialogFragmentAndroidInjectorProvider,
                            MenuBottomSheetDialogFragment::class.java to menuBottomSheetDialogFragmentAndroidInjectorProvider
                        ),
                        emptyMap()
                    )
            }
        }
}
