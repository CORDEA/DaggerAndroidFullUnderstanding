package jp.cordea.daggerandroidfullunderstanding.ui.home

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.daggerandroidfullunderstanding.R
import jp.cordea.daggerandroidfullunderstanding.databinding.HomeListItemBinding
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextResponse
import javax.inject.Inject

class HomeListItemModel(val title: String) {
    companion object {
        fun from(responses: List<TextResponse>) = responses.map { HomeListItemModel(it.text) }
    }
}

class HomeListItem private constructor(
    private val model: HomeListItemModel
) : BindableItem<HomeListItemBinding>() {
    class Factory @Inject constructor() {
        fun create(model: HomeListItemModel) = HomeListItem(model)
    }

    override fun getLayout(): Int = R.layout.home_list_item

    override fun bind(viewBinding: HomeListItemBinding, position: Int) {
        viewBinding.model = model
    }
}
