package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditTagViewModel @Inject constructor(
    private val repository: TagRepository,
    private val itemFactory: EditTagListItem.Factory
) : ViewModel() {
    private val _items = MutableLiveData<List<EditTagListItem>>()
    val items: LiveData<List<EditTagListItem>> = _items

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            repository.findAll(true)
                .map { EditTagListItemModel.from(it) }
                .map { models -> models.map { itemFactory.create(it) } }
                .collect { _items.value = it }
        }
    }
}
