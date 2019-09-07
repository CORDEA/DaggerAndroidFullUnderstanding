package jp.cordea.daggerandroidfullunderstanding.di

import androidx.fragment.app.createViewModelLazy
import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagListItem
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagViewModel
import javax.inject.Provider

class EditTagFragmentAndroidInjectorProvider(
    tagRepository: Provider<TagRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    private val editTagViewModelProvider =
        Provider {
            EditTagViewModel(tagRepository.get(), EditTagListItem.Factory())
        }

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<EditTagFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    instance.createViewModelLazy(
                        EditTagViewModel::class,
                        { instance.viewModelStore },
                        { ViewModelFactory(editTagViewModelProvider) }
                    )
            }
        }
}
