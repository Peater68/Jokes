package hu.bme.aut.jokes.ui.myjokes

sealed class MyJokesViewState

object Loading : MyJokesViewState()

data class MyJokesReady(val data: String = "") : MyJokesViewState()