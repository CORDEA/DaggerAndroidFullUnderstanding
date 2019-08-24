package jp.cordea.daggerandroidfullunderstanding.infra.text

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextDao @Inject constructor() {
    fun getTexts(): List<TextResponse> = emptyList()
}
