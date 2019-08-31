package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.text.TextLocalDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRemoteDataSource
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import javax.inject.Provider

class TextRepositoryImplProvider(
    private val remoteDataSourceprovider: Provider<TextRemoteDataSource>,
    private val localDataSourceProvider: Provider<TextLocalDataSource>
) : Provider<TextRepositoryImpl> {
    override fun get(): TextRepositoryImpl =
        TextRepositoryImpl(localDataSourceProvider.get(), remoteDataSourceprovider.get())
}
