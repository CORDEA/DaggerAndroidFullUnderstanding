package jp.cordea.daggerandroidfullunderstanding.infra.text

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRepositoryImpl @Inject constructor(
    private val localDataSource: TextLocalDataSource,
    private val remoteDataSource: TextRemoteDataSource
) : TextRepository {
    override fun findAll(forceRefresh: Boolean): List<TextResponse> =
        if (forceRefresh) remoteDataSource.findAll() else localDataSource.findAll()

    override fun find(forceRefresh: Boolean, id: Long): TextResponse =
        if (forceRefresh) remoteDataSource.find(id) else localDataSource.find(id)
}
