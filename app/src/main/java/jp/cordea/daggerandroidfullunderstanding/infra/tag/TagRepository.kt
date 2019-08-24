package jp.cordea.daggerandroidfullunderstanding.infra.tag

interface TagRepository {
    fun findAll(): List<TagResponse>
    fun find(id: String): TagResponse
}
