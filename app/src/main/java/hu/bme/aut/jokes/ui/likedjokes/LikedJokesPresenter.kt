package hu.bme.aut.jokes.ui.likedjokes

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import javax.inject.Inject

class LikedJokesPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getData(): String = withIOContext {
        ""
    }

}