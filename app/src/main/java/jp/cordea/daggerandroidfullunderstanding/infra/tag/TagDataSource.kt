package jp.cordea.daggerandroidfullunderstanding.infra.tag

interface TagDataSource {
    fun findAll(): List<TagResponse>
    fun find(id: Long): TagResponse
}
