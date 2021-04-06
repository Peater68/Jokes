package hu.bme.aut.jokes.ui.randomjokes

sealed class RandomJokesViewState

object Loading : RandomJokesViewState()

data class RandomJokesReady(val data: String = "") : RandomJokesViewState()