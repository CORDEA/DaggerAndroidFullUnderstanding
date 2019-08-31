package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentBindModule
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddViewModel
import javax.inject.Provider

class AddBottomSheetDialogFragmentAndroidInjectorProvider(
    textRepository: Provider<TextRepositoryImpl>
) : Provider<AndroidInjector.Factory<*>> {
    private val addViewModelProvider = Provider { AddViewModel(textRepository.get()) }

    override fun get(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<AddBottomSheetDialogFragment> {
            AndroidInjector { instance ->
                instance!!.viewModel =
                    AddBottomSheetDialogFragmentBindModule.provideViewModel(
                        instance,
                        ViewModelFactory(addViewModelProvider)
                    )
            }
        }
}
