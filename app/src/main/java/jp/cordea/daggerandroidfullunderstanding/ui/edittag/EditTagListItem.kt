package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.daggerandroidfullunderstanding.R
import jp.cordea.daggerandroidfullunderstanding.databinding.EditTagListItemBinding
import javax.inject.Inject

class EditTagListItemModel(val title: String)

class EditTagListItem private constructor(
    private val model: EditTagListItemModel
) : BindableItem<EditTagListItemBinding>() {
    class Factory @Inject constructor() {
        fun create(model: EditTagListItemModel) = EditTagListItem(model)
    }

    override fun getLayout(): Int = R.layout.edit_tag_list_item

    override fun bind(viewBinding: EditTagListItemBinding, position: Int) {
        viewBinding.model = model
    }
}
