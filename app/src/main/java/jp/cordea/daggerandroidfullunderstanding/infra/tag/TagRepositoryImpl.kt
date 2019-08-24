package jp.cordea.daggerandroidfullunderstanding.infra.tag

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRepositoryImpl @Inject constructor(
    private val localDataSource: TagLocalDataSource,
    private val remoteDataSource: TagRemoteDataSource
) : TagRepository {
    override fun findAll(): List<TagResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(id: String): TagResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
