package hu.bme.aut.jokes.ui.myjokes

import hu.bme.aut.jokes.ui.common.model.Joke

sealed class MyJokesViewState

object Loading : MyJokesViewState()

object Error : MyJokesViewState()

data class MyJokesContent(val jokes: List<Joke>) : MyJokesViewState()