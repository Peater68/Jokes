package hu.bme.aut.jokes.ui.likedjokes

import hu.bme.aut.jokes.ui.common.model.Joke

sealed class LikedJokesViewState

object Loading : LikedJokesViewState()

object Error : LikedJokesViewState()

data class LikedJokesContent(val jokes: List<Joke>) : LikedJokesViewState()