package jp.cordea.daggerandroidfullunderstanding.infra.text

import kotlinx.coroutines.flow.Flow

interface TextRepository {
    fun add(request: TextRequest): Flow<TextResponse>
    fun findAll(forceRefresh: Boolean): Flow<List<TextResponse>>
    fun find(forceRefresh: Boolean, id: Long): Flow<TextResponse>
}
