package hu.bme.aut.jokes.ui.likedjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.jokes.ui.common.model.Joke
import javax.inject.Inject

class LikedJokesViewModel @Inject constructor(
    private val likedJokesPresenter: LikedJokesPresenter
) : RainbowCakeViewModel<LikedJokesViewState>(Loading) {

    fun load() = execute {
        viewState = LikedJokesContent(likedJokesPresenter.getLikedJokes())
    }

    fun dislikeJoke(joke: Joke) = execute {
        (viewState as? LikedJokesContent)?.let { state ->
            likedJokesPresenter.dislikeJoke(joke.id)
            viewState = state.copy(jokes = state.jokes.toMutableList().apply { remove(joke) })
        }
    }
}