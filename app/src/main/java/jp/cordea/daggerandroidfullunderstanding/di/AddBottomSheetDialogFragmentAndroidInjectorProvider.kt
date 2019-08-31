package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentBindModule_ProvideViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment_MembersInjector
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddViewModel_Factory
import javax.inject.Provider

class AddBottomSheetDialogFragmentAndroidInjectorProvider(
    textRepository: Provider<TextRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    @Suppress("UNCHECKED_CAST")
    private val addViewModelProvider =
        AddViewModel_Factory.create(textRepository as Provider<TextRepository>)

    override fun get(): AndroidInjector.Factory<*> =
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