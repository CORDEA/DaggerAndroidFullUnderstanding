package jp.cordea.daggerandroidfullunderstanding.infra.tag

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) : TagDataSource {
    override fun findAll(): Flow<List<TagResponse>> = apiClient.fetchTags()

    override fun find(id: Long): Flow<TagResponse> =
        findAll().map { tags -> tags.first { it.id == id } }
}
