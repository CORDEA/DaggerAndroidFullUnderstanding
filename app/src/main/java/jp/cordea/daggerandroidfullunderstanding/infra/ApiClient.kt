package jp.cordea.daggerandroidfullunderstanding.infra

import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagResponse
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {
    fun fetchTags(): List<TagResponse> = emptyList()

    fun fetchTexts(): List<TextResponse> = emptyList()
}
