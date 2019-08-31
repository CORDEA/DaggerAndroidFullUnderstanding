package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.*
import javax.inject.Provider

class EditTagFragmentAndroidInjectorProvider(
    tagRepository: Provider<TagRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    @Suppress("UNCHECKED_CAST")
    private val editTagViewModelProvider =
        EditTagViewModel_Factory.create(
            tagRepository as Provider<TagRepository>,
            EditTagListItem_Factory_Factory.create()
        )

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<EditTagFragment> {
            AndroidInjector { instance ->
                EditTagFragment_MembersInjector.injectViewModel(
                    instance,
                    EditTagFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                        instance!!,
                        ViewModelFactory_Factory.newInstance(editTagViewModelProvider)
                    )
                )
            }
        }
}
