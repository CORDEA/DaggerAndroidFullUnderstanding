package jp.cordea.daggerandroidfullunderstanding.infra.tag

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagRepositoryImpl @Inject constructor(
    private val localDataSource: TagLocalDataSource,
    private val remoteDataSource: TagRemoteDataSource
) : TagRepository {
    @ExperimentalCoroutinesApi
    override fun add(request: TagRequest): Flow<TagResponse> =
        remoteDataSource.add(request).flowOn(Dispatchers.IO)

    @ExperimentalCoroutinesApi
    override fun findAll(forceRefresh: Boolean): Flow<List<TagResponse>> =
        if (forceRefresh) remoteDataSource.findAll() else localDataSource.findAll()
            .flowOn(Dispatchers.IO)

    @ExperimentalCoroutinesApi
    override fun find(forceRefresh: Boolean, id: Long): Flow<TagResponse> =
        if (forceRefresh) remoteDataSource.find(id) else localDataSource.find(id)
            .flowOn(Dispatchers.IO)
}
