package jp.cordea.daggerandroidfullunderstanding.ui.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import jp.cordea.daggerandroidfullunderstanding.R

class AddBottomSheetDialogFragment : BottomSheetDialogFragment() {
    companion object {
        private const val TAG = "AddBottomSheetDialogFragment"

        fun newInstance() = AddBottomSheetDialogFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_bottom_sheet_dialog_fragment, container, false)
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }
}
