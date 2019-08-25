package jp.cordea.daggerandroidfullunderstanding.infra.text

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextLocalDataSource @Inject constructor(
    private val textDao: TextDao
) : TextDataSource {
    override fun findAll(): Flow<List<TextResponse>> = flowOf(textDao.getTexts())

    override fun find(id: Long): Flow<TextResponse> =
        findAll().map { texts -> texts.first { it.id == id } }
}
