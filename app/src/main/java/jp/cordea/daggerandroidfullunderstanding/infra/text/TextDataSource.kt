package jp.cordea.daggerandroidfullunderstanding.infra.text

import kotlinx.coroutines.flow.Flow

interface TextDataSource {
    fun findAll(): Flow<List<TextResponse>>
    fun find(id: Long): Flow<TextResponse>
}
