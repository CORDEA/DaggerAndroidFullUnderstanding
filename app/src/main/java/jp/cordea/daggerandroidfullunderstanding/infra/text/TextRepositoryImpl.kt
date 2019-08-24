package jp.cordea.daggerandroidfullunderstanding.infra.text

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRepositoryImpl @Inject constructor(
    private val localDataSource: TextLocalDataSource,
    private val remoteDataSource: TextRemoteDataSource
) : TextRepository {
    override fun findAll(): List<TextResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(id: Long): TextResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
