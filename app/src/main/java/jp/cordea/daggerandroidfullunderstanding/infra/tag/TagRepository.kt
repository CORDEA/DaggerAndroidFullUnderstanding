package jp.cordea.daggerandroidfullunderstanding.infra.tag

import kotlinx.coroutines.flow.Flow

interface TagRepository {
    fun findAll(forceRefresh: Boolean): Flow<List<TagResponse>>
    fun find(forceRefresh: Boolean, id: Long): Flow<TagResponse>
}
