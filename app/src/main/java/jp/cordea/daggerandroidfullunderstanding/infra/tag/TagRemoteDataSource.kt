package jp.cordea.daggerandroidfullunderstanding.infra.tag

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) {
    fun add(request: TagRequest): Flow<TagResponse> = apiClient.addTag(request)

    fun findAll(): Flow<List<TagResponse>> = apiClient.fetchTags()

    fun find(id: Long): Flow<TagResponse> =
        findAll().map { tags -> tags.first { it.id == id } }
}
