package hu.bme.aut.jokes.data.network

import hu.bme.aut.jokes.data.network.api.RealApi
import hu.bme.aut.jokes.data.network.model.JokeDto
import hu.bme.aut.jokes.domain.model.DomainJoke
import hu.bme.aut.jokes.domain.model.toDomainJoke
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val realApi: RealApi
) {

    companion object {
        private const val RANDOM_JOKE_AMOUNT = 7
    }

    suspend fun getCategories(): List<String> {
        return realApi.getCategories().body()?.categories ?: emptyList()
    }

    suspend fun getJokesByCategories(categories: List<String>): List<DomainJoke> {
        val responseBody =
            realApi.getJokeAny(categories.joinToString(separator = ","), RANDOM_JOKE_AMOUNT).body()

        return responseBody?.jokes?.map(JokeDto::toDomainJoke) ?: emptyList()
    }

    // TODO: add remaining fake calls
}