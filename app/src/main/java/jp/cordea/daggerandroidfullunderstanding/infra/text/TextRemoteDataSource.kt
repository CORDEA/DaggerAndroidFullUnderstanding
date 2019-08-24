package jp.cordea.daggerandroidfullunderstanding.infra.text

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) : TextRepository {
    override fun findAll(): List<TextResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(id: Long): TextResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
