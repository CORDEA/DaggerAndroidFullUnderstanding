package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment
import javax.inject.Provider

class EditTagFragmentSubcomponentFactory(
    private val tagRepository: Provider<TagRepositoryImpl>
) : EditTagFragmentModuleContributeEditTagFragment.Subcomponent.Factory {
    override fun create(instance: EditTagFragment?): AndroidInjector<EditTagFragment> =
        EditTagFragmentSubcomponentImpl(instance!!, tagRepository)
}
