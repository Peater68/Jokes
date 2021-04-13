package hu.bme.aut.jokes.data.network.api

import hu.bme.aut.jokes.data.network.model.CategoriesDto
import hu.bme.aut.jokes.data.network.model.JokesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RealApi {
    /**
     * Get joke categories
     * Get categories of jokes
     * Responses:
     *  - 200: OK
     *  - 400: Bad Request
     *  - 404: Not Found
     *  - 500: Internal Server Error
     *
     * @return [CategoriesDto]
     */
    @GET("categories")
    suspend fun getCategories(): Response<CategoriesDto>

    /**
     * Get reandom jokes
     * Get random jokes
     * Responses:
     *  - 200: OK
     *  - 400: Bad Request
     *  - 404: Not Found
     *  - 500: Internal Server Error
     *
     * @param amount
     * @return [JokesDto]
     */
    @GET("joke/Any")
    suspend fun getJokeAny(@Query("amount") amount: java.math.BigDecimal): Response<JokesDto>

}
