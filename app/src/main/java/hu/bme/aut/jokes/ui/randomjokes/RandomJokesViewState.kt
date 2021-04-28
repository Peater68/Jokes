package hu.bme.aut.jokes.ui.randomjokes

import hu.bme.aut.jokes.ui.randomjokes.model.Joke

sealed class RandomJokesViewState

object Loading : RandomJokesViewState()

object Error : RandomJokesViewState()

data class RandomJokesContent(
    val jokes: List<Joke>,
    val categories: List<String>,
) : RandomJokesViewState()