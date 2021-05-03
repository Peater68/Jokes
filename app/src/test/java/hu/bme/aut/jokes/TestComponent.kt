package hu.bme.aut.jokes

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.bme.aut.jokes.di.AppComponent
import hu.bme.aut.jokes.di.ViewModelModule
import hu.bme.aut.jokes.mock.JokesInteractorTest
import hu.bme.aut.jokes.mock.MockInteractorModule
import hu.bme.aut.jokes.mock.disk.MockDiskModule
import hu.bme.aut.jokes.mock.network.MockNetworkModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MockNetworkModule::class,
        MockDiskModule::class,
        ViewModelModule::class,
        MockInteractorModule::class,
        RainbowCakeModule::class
    ]
)
@ExperimentalCoroutinesApi
interface TestComponent : AppComponent {
    fun inject(jokesInteractorTest: JokesInteractorTest)
}