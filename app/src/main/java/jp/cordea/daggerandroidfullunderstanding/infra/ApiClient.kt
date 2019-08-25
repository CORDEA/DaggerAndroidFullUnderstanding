package jp.cordea.daggerandroidfullunderstanding.infra

import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagResponse
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {
    fun fetchTags(): Flow<List<TagResponse>> = flowOf(emptyList())

    fun fetchTexts(): Flow<List<TextResponse>> = flowOf(emptyList())
}
