package jp.cordea.daggerandroidfullunderstanding.infra

import dagger.Binds
import dagger.Module
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepository
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl

@Module
interface RepositoryModule {
    @Binds
    fun bindTagRepository(repositoryImpl: TagRepositoryImpl): TagRepository

    @Binds
    fun bindTextRepository(repositoryImpl: TextRepositoryImpl): TextRepository
}
