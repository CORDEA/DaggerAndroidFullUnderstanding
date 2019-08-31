package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagDao
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagLocalDataSource
import javax.inject.Provider

class TagLocalDataSourceProvider(
    private val tagDaoProvider: Provider<TagDao>
) : Provider<TagLocalDataSource> {
    override fun get(): TagLocalDataSource = TagLocalDataSource(tagDaoProvider.get())
}
