package jp.cordea.daggerandroidfullunderstanding.infra

import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRequest
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagResponse
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRequest
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() {
    fun addTag(request: TagRequest): Flow<TagResponse> = flowOf(TagResponse(1, request.tag))

    fun fetchTags(): Flow<List<TagResponse>> = flowOf(emptyList())

    fun addText(request: TextRequest): Flow<TextResponse> = flowOf(TextResponse(1, request.text))

    fun fetchTexts(): Flow<List<TextResponse>> =
        flowOf((0..50).map { TextResponse(it.toLong(), it.toString()) })
}
