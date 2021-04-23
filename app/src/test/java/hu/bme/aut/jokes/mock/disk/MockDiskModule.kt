package hu.bme.aut.jokes.mock.disk

import dagger.Module
import dagger.Provides
import hu.bme.aut.jokes.data.disk.dao.JokeDao
import javax.inject.Singleton

@Module
class MockDiskModule {

    @Provides
    @Singleton
    fun provideJokeDao(): JokeDao = MockJokeDao()

}