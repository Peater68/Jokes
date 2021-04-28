package hu.bme.aut.jokes.domain

import hu.bme.aut.jokes.data.disk.DiskDataSource
import hu.bme.aut.jokes.data.network.NetworkDataSource
import hu.bme.aut.jokes.domain.model.DomainJoke
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource
) {
    suspend fun getCategories(): List<String> {
        return networkDataSource.getCategories()
    }

    suspend fun getJokesByCategories(categories: List<String>): List<DomainJoke> {
        return networkDataSource.getJokesByCategories(categories)
    }

    suspend fun isJokeSaved(id: Long): Boolean {
        return diskDataSource.isJokeSaved(id)
    }

    suspend fun saveLikedJoke(joke: DomainJoke) {
        diskDataSource.saveLikedJoke(joke)
    }

    suspend fun saveMyJoke(joke: DomainJoke) {
        diskDataSource.saveMyJoke(joke)
    }

    suspend fun getLikedJokes() = diskDataSource.getLikedJokes()

    suspend fun getMyJokes() = diskDataSource.getMyJokes()

    suspend fun deleteJokeById(jokeId: Long) {
        diskDataSource.deleteJokeById(jokeId)
    }

    suspend fun deleteAllJokes() {
        diskDataSource.deleteAllJokes()
    }
}