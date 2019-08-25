package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.android.support.AndroidSupportInjection
import jp.cordea.daggerandroidfullunderstanding.R
import kotlinx.android.synthetic.main.edit_tag_fragment.*
import javax.inject.Inject

class EditTagFragment : Fragment() {
    @Inject
    lateinit var viewModel: Lazy<EditTagViewModel>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.edit_tag_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GroupAdapter<ViewHolder>()
        recyclerView.adapter = adapter
        viewModel.value.items
            .observe(this, Observer {
                adapter.addAll(it)
            })
    }
}
