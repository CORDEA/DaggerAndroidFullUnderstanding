package jp.cordea.daggerandroidfullunderstanding.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRequest
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddViewModel @Inject constructor(
    private val repository: TextRepository
) : ViewModel() {

    fun addText(text: String) {
        viewModelScope.launch {
            repository.add(TextRequest(text))
                .collect { }
        }
    }
}
