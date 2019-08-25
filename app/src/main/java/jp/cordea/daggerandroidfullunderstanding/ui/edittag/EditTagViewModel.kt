package jp.cordea.daggerandroidfullunderstanding.ui.edittag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class EditTagViewModel @Inject constructor() : ViewModel() {
    private val _items = MutableLiveData<List<EditTagListItem>>()
    val items: LiveData<List<EditTagListItem>> = _items
}
