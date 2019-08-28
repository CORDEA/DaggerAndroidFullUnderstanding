package jp.cordea.daggerandroidfullunderstanding.di

import dagger.android.AndroidInjector
import jp.cordea.daggerandroidfullunderstanding.MainActivity
import jp.cordea.daggerandroidfullunderstanding.infra.tag.TagRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import javax.inject.Provider

class MainActivitySubcomponentFactory(
    private val textRepository: Provider<TextRepositoryImpl>,
    private val tagRepository: Provider<TagRepositoryImpl>,
    private val mainActivitySubcomponentFactoryProvider: Provider<MainActivityModuleContributeMainActivity.Subcomponent.Factory>
) : MainActivityModuleContributeMainActivity.Subcomponent.Factory {
    override fun create(instance: MainActivity?): AndroidInjector<MainActivity> =
        MainActivitySubcomponentImpl(
            textRepository,
            tagRepository,
            mainActivitySubcomponentFactoryProvider
        )
}
