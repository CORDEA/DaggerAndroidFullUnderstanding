package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.ui.add.AddBottomSheetDialogFragmentModule_ContributeAddBottomSheetDialogFragment
import javax.inject.Provider

class AddBottomSheetDialogFragmentSubcomponentFactory(
    private val textRepository: Provider<TextRepositoryImpl>
) : AddBottomSheetDialogFragmentModule_ContributeAddBottomSheetDialogFragment.AddBottomSheetDialogFragmentSubcomponent.Factory {

    override fun create(instance: AddBottomSheetDialogFragment?): AndroidInjector<AddBottomSheetDialogFragment> =
        AddBottomSheetDialogFragmentSubcomponentImpl(instance!!, textRepository)
}
