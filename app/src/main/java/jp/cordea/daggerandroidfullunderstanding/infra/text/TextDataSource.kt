package jp.cordea.daggerandroidfullunderstanding.infra.text

interface TextDataSource {
    fun findAll(): List<TextResponse>
    fun find(id: Long): TextResponse
}
