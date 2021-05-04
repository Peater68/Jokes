package hu.bme.aut.jokes.mock.network

import hu.bme.aut.jokes.data.network.api.FakeApi
import hu.bme.aut.jokes.data.network.model.FlagsDto
import hu.bme.aut.jokes.data.network.model.JokeDto
import hu.bme.aut.jokes.data.network.model.JokesDto
import retrofit2.Response

class MockFakeApi : FakeApi {
    override suspend fun deleteJokeJokeId(jokeId: String): Response<Unit> {
        return Response.success(Unit)
    }

    override suspend fun getJokeLiked(): Response<JokesDto> {
        val jokes = (1..3).map {
            val isEven = it % 2 == 0
            JokeDto(
                category = "category$it",
                type = if (isEven) JokeDto.Type.SINGLE else JokeDto.Type.TWOPART,
                flags = FlagsDto(
                    nsfw = true,
                    religious = false,
                    political = false,
                    racist = true,
                    sexist = false,
                    explicit = false
                ),
                id = it.toLong(),
                safe = isEven,
                lang = "en",
                error = false,
                setup = if (isEven) null else "setup",
                delivery = if (isEven) null else "delivery",
                joke = if (isEven) "joke" else null,
            )
        }

        val responseBody = JokesDto(
            error = false,
            amount = jokes.size,
            jokes = jokes
        )

        return Response.success(responseBody)
    }

    override suspend fun getJokeMy(): Response<JokesDto> {
        val jokes = (1..4).map {
            val isEven = it % 2 == 0
            JokeDto(
                category = "category$it",
                type = if (isEven) JokeDto.Type.SINGLE else JokeDto.Type.TWOPART,
                flags = FlagsDto(
                    nsfw = true,
                    religious = false,
                    political = false,
                    racist = true,
                    sexist = false,
                    explicit = false
                ),
                id = it.toLong(),
                safe = isEven,
                lang = "en",
                error = false,
                setup = if (isEven) null else "setup",
                delivery = if (isEven) null else "delivery",
                joke = if (isEven) "joke" else null,
            )
        }

        val responseBody = JokesDto(
            error = false,
            amount = jokes.size,
            jokes = jokes
        )

        return Response.success(responseBody)
    }

    override suspend fun postJoke(jokeDto: JokeDto?): Response<Unit> {
        return Response.success(Unit)
    }

    override suspend fun putJokeJokeId(jokeId: String, jokeDto: JokeDto?): Response<Unit> {
        return Response.success(Unit)
    }
}