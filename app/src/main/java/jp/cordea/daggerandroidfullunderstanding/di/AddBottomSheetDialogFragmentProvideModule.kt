package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentBindModule_ProvideViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment_MembersInjector
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddViewModel_Factory
import javax.inject.Provider

@Module
class AddBottomSheetDialogFragmentProvideModule(
    textRepository: Provider<TextRepositoryImpl>
) {
    @Suppress("UNCHECKED_CAST")
    private val addViewModelProvider =
        AddViewModel_Factory.create(textRepository as Provider<TextRepository>)

    @Provides
    @IntoMap
    @ClassKey(AddBottomSheetDialogFragment::class)
    fun provideAndroidInjectorFactory(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<AddBottomSheetDialogFragment> {
            AndroidInjector { instance ->
                AddBottomSheetDialogFragment_MembersInjector.injectViewModel(
                    instance,
                    AddBottomSheetDialogFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                        instance!!,
                        ViewModelFactory_Factory.newInstance(addViewModelProvider)
                    )
                )
            }
        }
}
