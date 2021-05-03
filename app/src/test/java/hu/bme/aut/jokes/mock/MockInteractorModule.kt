package hu.bme.aut.jokes.mock

import dagger.Module
import dagger.Provides
import hu.bme.aut.jokes.data.cache.CategoryCache
import hu.bme.aut.jokes.data.disk.DiskDataSource
import hu.bme.aut.jokes.data.network.NetworkDataSource
import hu.bme.aut.jokes.domain.JokesInteractor
import javax.inject.Singleton

@Module
class MockInteractorModule {

    @Provides
    @Singleton
    fun bindJokesInteractor(
        networkDataSource: NetworkDataSource,
        diskDataSource: DiskDataSource,
        categoryCache: CategoryCache
    ) = JokesInteractor(networkDataSource, diskDataSource, categoryCache)
}