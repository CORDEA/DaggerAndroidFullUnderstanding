package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import javax.inject.Provider

class CreateTagFragmentSubcomponentFactory(
    private val tagRepository: Provider<TagRepositoryImpl>
) : CreateTagFragmentModuleContributeCreateTagFragment.Subcomponent.Factory {
    override fun create(instance: CreateTagFragment?): AndroidInjector<CreateTagFragment> =
        CreateTagFragmentSubcomponentImpl(instance!!, tagRepository)
}
