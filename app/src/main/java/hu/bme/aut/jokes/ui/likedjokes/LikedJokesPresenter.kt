package hu.bme.aut.jokes.ui.likedjokes

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import hu.bme.aut.jokes.ui.common.model.toUIModel
import javax.inject.Inject

class LikedJokesPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getLikedJokes() = withIOContext {
        jokesInteractor.getLikedJokes().map { it.toUIModel(true) }
    }

    suspend fun dislikeJoke(id: Long) = withIOContext {
        jokesInteractor.setJokeLike(id, false)
    }

}