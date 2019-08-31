package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragmentBindModule_ProvideViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagFragment_MembersInjector
import jp.cordea.daggerandroidfullunderstanding.ui.createtag.CreateTagViewModel_Factory
import javax.inject.Provider

@Module
class CreateTagFragmentProvideModule(
    tagRepository: Provider<TagRepositoryImpl>
) {
    @Suppress("UNCHECKED_CAST")
    private val createTagViewModelProvider =
        CreateTagViewModel_Factory.create(tagRepository as Provider<TagRepository>)

    @Provides
    @IntoMap
    @ClassKey(CreateTagFragment::class)
    fun provideAndroidInjectorFactory(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<CreateTagFragment> {
            AndroidInjector { instance ->
                CreateTagFragment_MembersInjector.injectViewModel(
                    instance,
                    CreateTagFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                        instance!!,
                        ViewModelFactory_Factory.newInstance(createTagViewModelProvider)
                    )
                )
            }
        }
}
