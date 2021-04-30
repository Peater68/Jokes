package hu.bme.aut.jokes.ui.newjoke

import hu.bme.aut.jokes.domain.model.Flag

sealed class NewJokeViewState

object Loading : NewJokeViewState()

data class NewJokeContent(
    val categories: List<String>,
    val selectedCategory: String,
    val selectedFlags: List<Flag> = emptyList(),
    val isSafe: Boolean = true,
    val joke: String = ""
) : NewJokeViewState()