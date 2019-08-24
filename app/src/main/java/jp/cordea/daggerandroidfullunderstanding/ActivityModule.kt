package jp.cordea.daggerandroidfullunderstanding

import dagger.Module

@Module(
    includes = [
        MainActivityModule::class
    ]
)
interface ActivityModule
