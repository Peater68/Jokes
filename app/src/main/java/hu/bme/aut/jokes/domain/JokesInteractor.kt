package hu.bme.aut.jokes.domain

import hu.bme.aut.jokes.data.cache.CategoryCache
import hu.bme.aut.jokes.data.disk.DiskDataSource
import hu.bme.aut.jokes.data.network.NetworkDataSource
import hu.bme.aut.jokes.domain.model.DomainJoke
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokesInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource,
    private val categoryCache: CategoryCache
) {
    suspend fun getCategories(): List<String> {
        if (categoryCache.categories.isEmpty()) {
            categoryCache.categories = networkDataSource.getCategories()
        }
        return categoryCache.categories
    }

    suspend fun getJokesByCategories(categories: List<String>): List<DomainJoke> {
        val jokes = networkDataSource.getJokesByCategories(categories)

        return if (jokes.isNotEmpty()) {
            diskDataSource.deleteRandomJokes()
            jokes.onEach { diskDataSource.saveRandomJoke(it) }
        } else {
            diskDataSource.getRandomJokes()
        }
    }

    suspend fun isJokeLiked(id: Long): Boolean {
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

    suspend fun setJokeLike(id: Long, isLiked: Boolean) {
        diskDataSource.setJokeLike(id, isLiked)
    }
}