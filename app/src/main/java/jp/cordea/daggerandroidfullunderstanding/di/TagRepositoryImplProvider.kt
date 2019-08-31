package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagLocalDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRemoteDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import javax.inject.Provider

class TagRepositoryImplProvider(
    private val remoteDataSourceprovider: Provider<TagRemoteDataSource>,
    private val localDataSourceProvider: Provider<TagLocalDataSource>
) : Provider<TagRepositoryImpl> {
    override fun get(): TagRepositoryImpl =
        TagRepositoryImpl(localDataSourceProvider.get(), remoteDataSourceprovider.get())
}
