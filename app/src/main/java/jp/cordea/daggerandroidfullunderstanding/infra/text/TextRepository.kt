package jp.cordea.daggerandroidfullunderstanding.infra.text

interface TextRepository {
    fun findAll(): List<TextResponse>
    fun find(id: Long): TextResponse
}
