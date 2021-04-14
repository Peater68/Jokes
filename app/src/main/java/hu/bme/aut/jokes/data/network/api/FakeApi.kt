package hu.bme.aut.jokes.data.network.api

import hu.bme.aut.jokes.data.network.model.JokeDto
import hu.bme.aut.jokes.data.network.model.JokesDto
import retrofit2.Response
import retrofit2.http.*

interface FakeApi {
    /**
     *
     * Delete joke by id
     * Responses:
     *  - 200: OK
     *  - 404: Not Found
     *  - 500: Internal Server Error
     *
     * @param jokeId
     * @return [Unit]
     */
    @DELETE("joke/{jokeId}")
    suspend fun deleteJokeJokeId(@Path("jokeId") jokeId: kotlin.String): Response<Unit>

    /**
     * Get likes jokes
     * Get jokes liked by current user
     * Responses:
     *  - 200: OK
     *  - 400: Bad Request
     *  - 404: Not Found
     *  - 500: Internal Server Error
     *
     * @return [JokesDto]
     */
    @GET("joke/liked")
    suspend fun getJokeLiked(): Response<JokesDto>

    /**
     * Get current user&#39;s jokes
     * Get current users jokes
     * Responses:
     *  - 200: OK
     *  - 400: Bad Request
     *  - 404: Not Found
     *  - 500: Internal Server Error
     *
     * @return [JokesDto]
     */
    @GET("joke/my")
    suspend fun getJokeMy(): Response<JokesDto>

    /**
     *
     * Create a new joke
     * Responses:
     *  - 200: OK
     *  - 201: Created
     *  - 400: Bad Request
     *  - 404: Not Found
     *  - 500: Internal Server Error
     *
     * @param jokeDto  (optional)
     * @return [Unit]
     */
    @POST("joke")
    suspend fun postJoke(@Body jokeDto: JokeDto? = null): Response<Unit>

    /**
     *
     * Update your joke
     * Responses:
     *  - 200: OK
     *
     * @param jokeId
     * @param jokeDto  (optional)
     * @return [Unit]
     */
    @PUT("joke/{jokeId}")
    suspend fun putJokeJokeId(
        @Path("jokeId") jokeId: kotlin.String,
        @Body jokeDto: JokeDto? = null
    ): Response<Unit>

}
