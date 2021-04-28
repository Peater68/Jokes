package hu.bme.aut.jokes.ui.randomjokes

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import hu.bme.aut.jokes.ui.randomjokes.model.toUIModel
import javax.inject.Inject

class RandomJokesPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getRandomJokesByCategories(categories: List<String>) = withIOContext {
        jokesInteractor.getJokesByCategories(categories).map {
            it.toUIModel(jokesInteractor.isJokeSaved(it.id))
        }
    }

    suspend fun getCategories() = withIOContext {
        jokesInteractor.getCategories()
    }

}