package jp.cordea.daggerandroidfullunderstanding.ui.createtag

import androidx.lifecycle.ViewModel
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import javax.inject.Inject

class CreateTagViewModel @Inject constructor(
    private val repository: TagRepository
) : ViewModel() {
    // TODO: Implement the ViewModel
}
