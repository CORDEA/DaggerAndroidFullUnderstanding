package jp.cordea.daggerandroidfullunderstanding.di

import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.daggerandroidfullunderstanding.ViewModelFactory_Factory
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepository
import jp.cordea.daggerandroidfullunderstanding.infra.text.TextRepositoryImpl
import jp.cordea.daggerandroidfullunderstanding.ui.home.*
import javax.inject.Provider

@Module
class HomeFragmentProvideModule(
    textRepository: Provider<TextRepositoryImpl>
) {
    @Suppress("UNCHECKED_CAST")
    private val homeViewModelProvider =
        HomeViewModel_Factory.create(
            textRepository as Provider<TextRepository>,
            HomeListItem_Factory_Factory.create()
        )

    @Provides
    @IntoMap
    @ClassKey(HomeFragment::class)
    fun provideAndroidInjectorFactory(): AndroidInjector.Factory<*> =
        AndroidInjector.Factory<HomeFragment> {
            AndroidInjector { instance ->
                HomeFragment_MembersInjector.injectViewModel(
                    instance,
                    HomeFragmentBindModule_ProvideViewModelFactory.provideViewModel(
                        instance!!,
                        ViewModelFactory_Factory.newInstance(homeViewModelProvider)
                    )
                )
            }
        }

}
