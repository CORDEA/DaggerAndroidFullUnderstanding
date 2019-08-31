package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.edittag.*
import javax.inject.Provider

@Module
class EditTagFragmentProvideModule(
    tagRepository: Provider<TagRepositoryImpl>
) {
    @Suppress("UNCHECKED_CAST")
    private val editTagViewModelProvider =
        EditTagViewModel_Factory.create(
            tagRepository as Provider<TagRepository>,
            EditTagListItem_Factory_Factory.create()
        )

    @Provides
    @IntoMap
    @ClassKey(EditTagFragment::class)
    fun provideAndroidInjectorFactory(): AndroidInjector.Factory<*> =
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
