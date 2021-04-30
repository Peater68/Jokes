package hu.bme.aut.jokes.ui.myjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import hu.bme.aut.jokes.ui.common.model.Joke
import javax.inject.Inject

class MyJokesViewModel @Inject constructor(
    private val myJokesPresenter: MyJokesPresenter
) : RainbowCakeViewModel<MyJokesViewState>(Loading) {

    fun load() = execute {
        viewState = MyJokesContent(myJokesPresenter.getMyJokes())
    }

    fun deleteJoke(joke: Joke) = execute {
        (viewState as? MyJokesContent)?.let { state ->
            myJokesPresenter.deleteJoke(joke.id)

            viewState = state.copy(jokes = state.jokes.toMutableList().apply { remove(joke) })
        }
    }

}