package hu.bme.aut.jokes.ui.newjoke

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.jokes.domain.model.Flag
import javax.inject.Inject

class NewJokeViewModel @Inject constructor(
    private val newJokePresenter: NewJokePresenter
) : RainbowCakeViewModel<NewJokeViewState>(Loading) {

    object JokeSaved : OneShotEvent

    fun load() = execute {
        if (viewState !is NewJokeContent) {
            val categories = newJokePresenter.getCategories()
            viewState = NewJokeContent(
                categories = categories,
                selectedCategory = categories.firstOrNull() ?: ""
            )
        }
    }

    fun saveSelectedCategoryToState(category: String) {
        (viewState as? NewJokeContent)?.let { state ->
            viewState = state.copy(selectedCategory = category)
        }
    }

    fun saveIsSafeToState(isSafe: Boolean) {
        (viewState as? NewJokeContent)?.let { state ->
            viewState = state.copy(isSafe = isSafe)
        }
    }

    fun saveFlagToState(flag: Flag, isAdded: Boolean) {
        (viewState as? NewJokeContent)?.let { state ->
            val flags = state.selectedFlags.toMutableList()
            if (isAdded) {
                flags.add(flag)
            } else {
                flags.remove(flag)
            }
            viewState = state.copy(selectedFlags = flags)
        }
    }

    fun saveJokeToState(joke: String) {
        (viewState as? NewJokeContent)?.let { state ->
            viewState = state.copy(joke = joke)
        }
    }

    fun submitJoke() = execute {
        (viewState as? NewJokeContent)?.let { state ->
            with(state) {
                newJokePresenter.submitJoke(
                    category = selectedCategory,
                    joke = joke,
                    safe = isSafe,
                    flags = selectedFlags
                )
            }

            postEvent(JokeSaved)
        }
    }

}