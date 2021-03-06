/**
 * JokeAPI
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package hu.bme.aut.jokes.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 * @param nsfw
 * @param religious
 * @param political
 * @param racist
 * @param sexist
 * @param explicit
 */
@JsonClass(generateAdapter = true)
data class FlagsDto(
    @Json(name = "nsfw")
    val nsfw: kotlin.Boolean,
    @Json(name = "religious")
    val religious: kotlin.Boolean,
    @Json(name = "political")
    val political: kotlin.Boolean,
    @Json(name = "racist")
    val racist: kotlin.Boolean,
    @Json(name = "sexist")
    val sexist: kotlin.Boolean,
    @Json(name = "explicit")
    val explicit: kotlin.Boolean
)

