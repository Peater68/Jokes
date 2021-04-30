package hu.bme.aut.jokes.mock.network

import hu.bme.aut.jokes.data.network.api.RealApi
import hu.bme.aut.jokes.data.network.model.CategoriesDto
import hu.bme.aut.jokes.data.network.model.FlagsDto
import hu.bme.aut.jokes.data.network.model.JokeDto
import hu.bme.aut.jokes.data.network.model.JokesDto
import retrofit2.Response

class MockRealApi : RealApi {
    override suspend fun getCategories(): Response<CategoriesDto> {
        val body = CategoriesDto(
            error = false,
            categories = listOf("Dark", "Misc", "Any"),
            categoryAliases = emptySet(),
            timestamp = 1L
        )
        return Response.success(body)
    }

    override suspend fun getJokeAny(category: String, amount: Int): Response<JokesDto> {
        val jokes = (1..amount).map {
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
            amount = amount,
            jokes = jokes
        )

        return Response.success(responseBody)
    }
}