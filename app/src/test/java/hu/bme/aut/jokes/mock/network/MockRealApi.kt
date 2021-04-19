package hu.bme.aut.jokes.mock.network

import hu.bme.aut.jokes.data.network.api.RealApi
import hu.bme.aut.jokes.data.network.model.CategoriesDto
import hu.bme.aut.jokes.data.network.model.JokesDto
import retrofit2.Response

class MockRealApi : RealApi {
    override suspend fun getCategories(): Response<CategoriesDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getJokeAny(category: String, amount: Int): Response<JokesDto> {
        TODO("Not yet implemented")
    }
}