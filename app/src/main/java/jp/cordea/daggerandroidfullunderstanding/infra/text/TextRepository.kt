package jp.cordea.daggerandroidfullunderstanding.infra.text

interface TextRepository {
    fun findAll(forceRefresh: Boolean): List<TextResponse>
    fun find(forceRefresh: Boolean, id: Long): TextResponse
}
