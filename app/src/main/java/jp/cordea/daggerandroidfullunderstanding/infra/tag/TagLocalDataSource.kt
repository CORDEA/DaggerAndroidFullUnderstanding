package jp.cordea.daggerandroidfullunderstanding.infra.tag

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagLocalDataSource @Inject constructor(
    private val tagDao: TagDao
) : TagDataSource {
    override fun findAll(): Flow<List<TagResponse>> = flowOf(tagDao.getTags())

    override fun find(id: Long): Flow<TagResponse> =
        findAll().map { tags -> tags.first { it.id == id } }
}
