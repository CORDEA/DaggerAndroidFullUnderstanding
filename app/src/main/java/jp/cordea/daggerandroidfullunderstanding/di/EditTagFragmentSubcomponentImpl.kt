package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.*
import javax.inject.Provider

class EditTagFragmentSubcomponentImpl(
    private val fragment: EditTagFragment,
    tagRepository: Provider<TagRepositoryImpl>
) : EditTagFragmentModuleContributeEditTagFragment.Subcomponent {
    @Suppress("UNCHECKED_CAST")
    private val editTagViewModelProvider =
        EditTagViewModel_Factory.create(
            tagRepository as Provider<TagRepository>,
            EditTagListItem_Factory_Factory.create()
        )

    override fun inject(instance: EditTagFragment?) {
        EditTagFragment_MembersInjector.injectViewModel(
            instance,
            EditTagFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                fragment,
                ViewModelFactory_Factory.newInstance(editTagViewModelProvider)
            )
        )
    }
}
