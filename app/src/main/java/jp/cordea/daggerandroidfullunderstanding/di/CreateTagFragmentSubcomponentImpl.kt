package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.*
import javax.inject.Provider

class CreateTagFragmentSubcomponentImpl(
    private val fragment: CreateTagFragment,
    tagRepository: Provider<TagRepositoryImpl>
) : CreateTagFragmentModule_ContributeCreateTagFragment.CreateTagFragmentSubcomponent {
    @Suppress("UNCHECKED_CAST")
    private val createTagViewModelProvider =
        CreateTagViewModel_Factory.create(tagRepository as Provider<TagRepository>)

    override fun inject(instance: CreateTagFragment?) {
        CreateTagFragment_MembersInjector.injectViewModel(
            instance,
            CreateTagFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                fragment,
                ViewModelFactory_Factory.newInstance(createTagViewModelProvider)
            )
        )
    }
}
