package jp.cordea.daggerandroidfullunderstanding.infra.tag

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagLocalDataSource @Inject constructor(
    private val tagDao: TagDao
) : TagDataSource {
    override fun findAll(): List<TagResponse> = tagDao.getTags()

    override fun find(id: Long): TagResponse = tagDao.getTags().first { it.id == id }
}
