package hu.bme.aut.jokes.ui.myjokes

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import hu.bme.aut.jokes.domain.model.DomainJoke
import hu.bme.aut.jokes.ui.common.model.toUIModel
import javax.inject.Inject

class MyJokesPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getMyJokes() = withIOContext {
        jokesInteractor.getMyJokes().map(DomainJoke::toUIModel)
    }

    suspend fun deleteJoke(id: Long) = withIOContext {
        jokesInteractor.deleteJokeById(id)
    }

}