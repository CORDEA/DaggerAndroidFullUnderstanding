package jp.cordea.daggerandroidfullunderstanding.infra.tag

interface TagRepository {
    fun findAll(forceRefresh: Boolean): List<TagResponse>
    fun find(forceRefresh: Boolean, id: Long): TagResponse
}
