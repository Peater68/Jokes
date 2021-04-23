package hu.bme.aut.jokes

import dagger.Component
import hu.bme.aut.jokes.mock.MockInteractorModule
import hu.bme.aut.jokes.mock.disk.MockDiskModule
import hu.bme.aut.jokes.mock.network.MockNetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        TestModule::class,
        MockNetworkModule::class,
        MockDiskModule::class,
        MockInteractorModule::class,
    ]
)
interface TestComponent