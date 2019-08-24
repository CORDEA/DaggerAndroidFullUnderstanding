package jp.cordea.daggerandroidfullunderstanding.infra.tag

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) : TagRepository {
    override fun findAll(): List<TagResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(id: String): TagResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
