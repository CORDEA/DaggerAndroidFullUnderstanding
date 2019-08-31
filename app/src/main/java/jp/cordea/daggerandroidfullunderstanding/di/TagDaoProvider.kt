package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagDao
import javax.inject.Provider

object TagDaoProvider : Provider<TagDao> {
    override fun get(): TagDao = TagDao()
}
