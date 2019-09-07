package jp.cordea.daggerandroidfullunderstanding.di

import androidx.fragment.app.createViewModelLazy
import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagViewModel
import javax.inject.Provider

class CreateTagFragmentAndroidInjectorProvider(
    tagRepository: Provider<TagRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    private val createTagViewModelProvider = Provider { CreateTagViewModel(tagRepository.get()) }

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<CreateTagFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    instance.createViewModelLazy(
                        CreateTagViewModel::class,
                        { instance.viewModelStore },
                        { ViewModelFactory(createTagViewModelProvider) }
                    )
            }
        }
}
