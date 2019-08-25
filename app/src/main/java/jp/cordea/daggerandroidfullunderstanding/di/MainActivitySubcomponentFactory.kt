package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.MainActivityModule_ContributeMainActivity
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import javax.inject.Provider

class MainActivitySubcomponentFactory(
    private val textRepository: Provider<TextRepositoryImpl>,
    private val tagRepository: Provider<TagRepositoryImpl>,
    private val mainActivitySubcomponentFactoryProvider: Provider<MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Factory>
) : MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Factory {
    override fun create(instance: MainActivity?): AndroidInjector<MainActivity> =
        MainActivitySubcomponentImpl(
            textRepository,
            tagRepository,
            mainActivitySubcomponentFactoryProvider
        )
}
