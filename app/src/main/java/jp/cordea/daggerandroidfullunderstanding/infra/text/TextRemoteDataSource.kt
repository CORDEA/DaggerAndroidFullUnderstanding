package jp.cordea.daggerandroidfullunderstanding.infra.text

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) : TextDataSource {
    override fun findAll(): Flow<List<TextResponse>> = apiClient.fetchTexts()

    override fun find(id: Long): Flow<TextResponse> =
        findAll().map { texts -> texts.first { it.id == id } }
}
