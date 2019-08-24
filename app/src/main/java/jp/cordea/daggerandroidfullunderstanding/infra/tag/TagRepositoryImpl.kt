package jp.cordea.daggerandroidfullunderstanding.infra.tag

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRepositoryImpl @Inject constructor(
    private val localDataSource: TagLocalDataSource,
    private val remoteDataSource: TagRemoteDataSource
) : TagRepository {
    override fun findAll(forceRefresh: Boolean): List<TagResponse> =
        if (forceRefresh) remoteDataSource.findAll() else localDataSource.findAll()

    override fun find(forceRefresh: Boolean, id: Long): TagResponse =
        if (forceRefresh) remoteDataSource.find(id) else localDataSource.find(id)
}
