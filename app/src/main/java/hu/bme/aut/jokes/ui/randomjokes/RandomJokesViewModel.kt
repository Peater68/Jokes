package hu.bme.aut.jokes.ui.randomjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.jokes.ui.common.model.Joke
import javax.inject.Inject

class RandomJokesViewModel @Inject constructor(
    private val randomJokesPresenter: RandomJokesPresenter
) : RainbowCakeViewModel<RandomJokesViewState>(Loading) {

    fun load() = execute {
        if (viewState !is RandomJokesContent) {
            val categories = randomJokesPresenter.getCategories()
            val jokes = randomJokesPresenter.getRandomJokesByCategories(listOf(categories.first()))

            viewState = RandomJokesContent(jokes, categories)
        }
    }

    fun getJokesForCategory(selectedCategory: String) = execute {
        (viewState as? RandomJokesContent)?.let { state ->
            viewState = Loading

            val jokes = randomJokesPresenter.getRandomJokesByCategories(listOf(selectedCategory))

            viewState = RandomJokesContent(jokes, state.categories, selectedCategory)
        }
    }

    fun likeJoke(joke: Joke) = execute {
        (viewState as? RandomJokesContent)?.let { state ->
            randomJokesPresenter.setJokeLike(joke.id, joke.isLiked.not())

            val index = state.jokes.indexOf(joke)
            val modifiedItem = joke.copy(isLiked = joke.isLiked.not())

            val jokes = state.jokes.toMutableList()
            jokes[index] = modifiedItem

            viewState = state.copy(jokes = jokes)
        }
    }

}