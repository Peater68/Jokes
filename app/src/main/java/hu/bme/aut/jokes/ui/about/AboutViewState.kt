package hu.bme.aut.jokes.ui.about

sealed class AboutViewState

object Loading : AboutViewState()

data class AboutContent(val aboutInfo: String) : AboutViewState()