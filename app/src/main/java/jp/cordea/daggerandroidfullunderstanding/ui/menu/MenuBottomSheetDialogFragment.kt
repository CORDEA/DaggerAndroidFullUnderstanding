package jp.cordea.daggerandroidfullunderstanding.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.R

class MenuBottomSheetDialogFragment : BottomSheetDialogFragment() {
    companion object {
        private const val TAG = "MenuBottomSheetDialogFragment"

        fun newInstance() = MenuBottomSheetDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_bottom_sheet_dialog_fragment, container, false)
    }

    fun show(manager: FragmentManager) {
        show(manager, tag)
    }
}
