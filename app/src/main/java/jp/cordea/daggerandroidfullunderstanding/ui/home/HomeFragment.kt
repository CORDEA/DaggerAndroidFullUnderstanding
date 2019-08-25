package jp.cordea.daggerandroidfullunderstanding.ui.home

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
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModel: Lazy<HomeViewModel>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.home_fragment, container, false)

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
