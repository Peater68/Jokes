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
 * @param alias
 * @param resolved
 */
@JsonClass(generateAdapter = true)
data class CategoryAliasDto(
    @Json(name = "alias")
    val alias: kotlin.String,
    @Json(name = "resolved")
    val resolved: kotlin.String
)

