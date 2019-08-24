package jp.cordea.daggerandroidfullunderstanding.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jp.cordea.daggerandroidfullunderstanding.R

class MenuBottomSheetDialogFragment : BottomSheetDialogFragment() {
    companion object {
        fun newInstance() = MenuBottomSheetDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_bottom_sheet_dialog_fragment, container, false)
    }
}
