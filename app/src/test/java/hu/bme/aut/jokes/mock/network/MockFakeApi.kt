package hu.bme.aut.jokes.mock.network

import hu.bme.aut.jokes.data.network.api.FakeApi
import hu.bme.aut.jokes.data.network.model.JokeDto
import hu.bme.aut.jokes.data.network.model.JokesDto
import retrofit2.Response

class MockFakeApi : FakeApi {
    override suspend fun deleteJokeJokeId(jokeId: String): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getJokeLiked(): Response<JokesDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getJokeMy(): Response<JokesDto> {
        TODO("Not yet implemented")
    }

    override suspend fun postJoke(jokeDto: JokeDto?): Response<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun putJokeJokeId(jokeId: String, jokeDto: JokeDto?): Response<Unit> {
        TODO("Not yet implemented")
    }
}