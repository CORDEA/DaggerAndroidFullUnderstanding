package jp.cordea.daggerandroidfullunderstanding.infra.text

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRepositoryImpl @Inject constructor(
    private val localDataSource: TextLocalDataSource,
    private val remoteDataSource: TextRemoteDataSource
) : TextRepository {
    @ExperimentalCoroutinesApi
    override fun findAll(forceRefresh: Boolean): Flow<List<TextResponse>> =
        if (forceRefresh) remoteDataSource.findAll() else localDataSource.findAll()
            .flowOn(Dispatchers.IO)

    @ExperimentalCoroutinesApi
    override fun find(forceRefresh: Boolean, id: Long): Flow<TextResponse> =
        if (forceRefresh) remoteDataSource.find(id) else localDataSource.find(id)
            .flowOn(Dispatchers.IO)
}
