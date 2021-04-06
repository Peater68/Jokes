package hu.bme.aut.jokes.ui.likedjokes

sealed class LikedJokesViewState

object Loading : LikedJokesViewState()

data class LikedJokesReady(val data: String = "") : LikedJokesViewState()