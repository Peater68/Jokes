package hu.bme.aut.jokes.domain

import hu.bme.aut.jokes.data.network.NetworkDataSource
import hu.bme.aut.jokes.domain.model.DomainJoke
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getCategories(): List<String> {
        return networkDataSource.getCategories()
    }

    suspend fun getJokesByCategories(categories: List<String>): List<DomainJoke> {
        return networkDataSource.getJokesByCategories(categories)
    }

    // TODO: add remaining calls
}