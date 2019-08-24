package jp.cordea.daggerandroidfullunderstanding.infra.text

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) : TextDataSource {
    override fun findAll(): List<TextResponse> = apiClient.fetchTexts()

    override fun find(id: Long): TextResponse = apiClient.fetchTexts().first { it.id == id }
}
