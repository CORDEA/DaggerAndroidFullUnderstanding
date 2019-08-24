package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jp.cordea.daggerandroidfullunderstanding.R

class EditTagFragment : Fragment() {
    private lateinit var viewModel: EditTagViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_tag_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EditTagViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
