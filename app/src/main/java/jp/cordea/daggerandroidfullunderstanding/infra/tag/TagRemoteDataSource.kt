package jp.cordea.daggerandroidfullunderstanding.infra.tag

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) : TagDataSource {
    override fun findAll(): List<TagResponse> = apiClient.fetchTags()

    override fun find(id: Long): TagResponse = apiClient.fetchTags().first { it.id == id }
}
