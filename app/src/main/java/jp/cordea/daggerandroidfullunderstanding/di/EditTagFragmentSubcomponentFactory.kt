package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.EditTagFragmentModule_ContributeEditTagFragment
import javax.inject.Provider

class EditTagFragmentSubcomponentFactory(
    private val tagRepository: Provider<TagRepositoryImpl>
) : EditTagFragmentModule_ContributeEditTagFragment.EditTagFragmentSubcomponent.Factory {
    override fun create(instance: EditTagFragment?): AndroidInjector<EditTagFragment> =
        EditTagFragmentSubcomponentImpl(instance!!, tagRepository)
}
