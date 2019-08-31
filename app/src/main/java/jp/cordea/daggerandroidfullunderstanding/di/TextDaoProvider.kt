package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.text.TextDao
import javax.inject.Provider

object TextDaoProvider : Provider<TextDao> {
    override fun get(): TextDao = TextDao()
}
