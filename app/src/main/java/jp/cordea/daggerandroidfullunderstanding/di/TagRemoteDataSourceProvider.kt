package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRemoteDataSource
import javax.inject.Provider

class TagRemoteDataSourceProvider(
    private val apiClientProvider: Provider<ApiClient>
) : Provider<TagRemoteDataSource> {
    override fun get(): TagRemoteDataSource = TagRemoteDataSource(apiClientProvider.get())
}
