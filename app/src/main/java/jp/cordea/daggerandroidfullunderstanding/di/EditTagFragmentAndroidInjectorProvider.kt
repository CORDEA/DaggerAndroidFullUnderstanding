package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragmentBindModule
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagListItem_Factory_Factory
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagViewModel
import javax.inject.Provider

class EditTagFragmentAndroidInjectorProvider(
    tagRepository: Provider<TagRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    private val editTagViewModelProvider =
        Provider {
            EditTagViewModel(tagRepository.get(), EditTagListItem_Factory_Factory.create().get())
        }

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<EditTagFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    EditTagFragmentBindModule.provideViewModel(
                        instance,
                        ViewModelFactory(editTagViewModelProvider)
                    )
            }
        }
}
