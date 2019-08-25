package jp.cordea.daggerandroidfullunderstanding.infra.tag

import kotlinx.coroutines.flow.Flow

interface TagDataSource {
    fun findAll(): Flow<List<TagResponse>>
    fun find(id: Long): Flow<TagResponse>
}
