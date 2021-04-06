package hu.bme.aut.jokes.ui.newjoke

sealed class NewJokeViewState

object Loading : NewJokeViewState()

data class NewJokeReady(val data: String = "") : NewJokeViewState()