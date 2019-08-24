package jp.cordea.daggerandroidfullunderstanding.ui.createtag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jp.cordea.daggerandroidfullunderstanding.R

class CreateTagFragment : Fragment() {
    private lateinit var viewModel: CreateTagViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_tag_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateTagViewModel::class.java)
        // TODO: Use the ViewModel
    }

}