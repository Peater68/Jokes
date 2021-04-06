package hu.bme.aut.jokes.ui.myjokes

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import javax.inject.Inject

class MyJokesPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getData(): String = withIOContext {
        ""
    }

}