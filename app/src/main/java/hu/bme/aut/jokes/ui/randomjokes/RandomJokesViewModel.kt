package hu.bme.aut.jokes.ui.randomjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class RandomJokesViewModel @Inject constructor(
    private val randomJokesPresenter: RandomJokesPresenter
) : RainbowCakeViewModel<RandomJokesViewState>(Loading) {

    fun load() = execute {
        val categories = randomJokesPresenter.getCategories()
        val jokes = randomJokesPresenter.getRandomJokesByCategories(listOf(categories.first()))

        viewState = RandomJokesContent(jokes, categories)
    }

    fun getJokesForCategory(selectedCategory: String) = execute {
        (viewState as? RandomJokesContent)?.let { state ->
            viewState = Loading

            val jokes = randomJokesPresenter.getRandomJokesByCategories(listOf(selectedCategory))

            viewState = RandomJokesContent(jokes, state.categories, selectedCategory)
        }
    }

}