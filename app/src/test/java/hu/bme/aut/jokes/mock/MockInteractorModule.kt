package hu.bme.aut.jokes.mock

import dagger.Binds
import dagger.Module
import hu.bme.aut.jokes.domain.JokesInteractor
import javax.inject.Singleton

@Module
abstract class MockInteractorModule() {
    @Binds
    @Singleton
    abstract fun bindJokesInteractor(): JokesInteractor
}