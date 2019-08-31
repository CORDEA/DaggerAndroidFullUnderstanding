package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRemoteDataSource
import javax.inject.Provider

class TextRemoteDataSourceProvider(
    private val apiClientProvider: Provider<ApiClient>
) : Provider<TextRemoteDataSource> {
    override fun get(): TextRemoteDataSource = TextRemoteDataSource(apiClientProvider.get())
}
