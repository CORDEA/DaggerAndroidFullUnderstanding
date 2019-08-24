package jp.cordea.daggerandroidfullunderstanding.infra.text

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextLocalDataSource @Inject constructor(
    private val textDao: TextDao
) : TextDataSource {
    override fun findAll(): List<TextResponse> = textDao.getTexts()

    override fun find(id: Long): TextResponse = textDao.getTexts().first { it.id == id }
}
