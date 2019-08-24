package jp.cordea.daggerandroidfullunderstanding.infra.tag

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagDao @Inject constructor() {
    fun getTags(): List<TagResponse> = emptyList()
}
