package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.text.TextDao
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextLocalDataSource
import javax.inject.Provider

class TextLocalDataSourceProvider(
    private val textDaoProvider: Provider<TextDao>
) : Provider<TextLocalDataSource> {
    override fun get(): TextLocalDataSource = TextLocalDataSource(textDaoProvider.get())
}
