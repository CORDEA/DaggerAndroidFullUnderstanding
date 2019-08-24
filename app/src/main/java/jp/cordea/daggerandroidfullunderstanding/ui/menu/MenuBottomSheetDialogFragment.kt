package jp.cordea.daggerandroidfullunderstanding.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import jp.cordea.daggerandroidfullunderstanding.R
import kotlinx.android.synthetic.main.menu_bottom_sheet_dialog_fragment.*

class MenuBottomSheetDialogFragment : BottomSheetDialogFragment() {
    companion object {
        private const val TAG = "MenuBottomSheetDialogFragment"

        fun newInstance() = MenuBottomSheetDialogFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.menu_bottom_sheet_dialog_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        create.setOnClickListener {
            findNavController().navigate(R.id.createTagFragment)
            dismiss()
        }
        edit.setOnClickListener {
            findNavController().navigate(R.id.editTagFragment)
            dismiss()
        }
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }
}
