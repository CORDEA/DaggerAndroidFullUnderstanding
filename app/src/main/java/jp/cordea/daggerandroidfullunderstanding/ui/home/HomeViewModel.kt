package jp.cordea.daggerandroidfullunderstanding.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: TextRepositoryImpl,
    private val itemFactory: HomeListItem.Factory
) : ViewModel() {
    private val _items = MutableLiveData<List<HomeListItem>>()
    val items: LiveData<List<HomeListItem>> = _items

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            repository.findAll(true)
                .map { HomeListItemModel.from(it) }
                .map { models -> models.map { itemFactory.create(it) } }
                .collect { _items.value = it }
        }
    }
}
