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
 * @param error
 * @param categories
 * @param categoryAliases
 * @param timestamp
 */
@JsonClass(generateAdapter = true)
data class CategoriesDto(
    @Json(name = "error")
    val error: kotlin.Boolean,
    @Json(name = "categories")
    val categories: kotlin.collections.List<kotlin.String>,
    @Json(name = "categoryAliases")
    val categoryAliases: kotlin.collections.Set<CategoryAliasDto>,
    @Json(name = "timestamp")
    val timestamp: kotlin.Long
)
