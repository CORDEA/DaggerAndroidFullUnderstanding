package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragmentBindModule
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagViewModel_Factory
import javax.inject.Provider

class CreateTagFragmentAndroidInjectorProvider(
    tagRepository: Provider<TagRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    @Suppress("UNCHECKED_CAST")
    private val createTagViewModelProvider =
        CreateTagViewModel_Factory.create(tagRepository as Provider<TagRepository>)

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<CreateTagFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    CreateTagFragmentBindModule.provideViewModel(
                        instance,
                        ViewModelFactory_Factory.newInstance(createTagViewModelProvider)
                    )
            }
        }
}
