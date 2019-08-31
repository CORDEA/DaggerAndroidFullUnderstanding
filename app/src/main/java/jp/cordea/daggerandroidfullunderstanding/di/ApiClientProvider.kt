package jp.cordea.daggerandroidfullunderstanding.di

import jp.cordea.daggerandroidfullunderstanding.infra.ApiClient
import javax.inject.Provider

object ApiClientProvider : Provider<ApiClient> {
    override fun get(): ApiClient = ApiClient()
}
