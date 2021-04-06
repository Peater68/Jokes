package hu.bme.aut.jokes.ui.about

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import javax.inject.Inject

class AboutPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getData(): String = withIOContext {
        ""
    }

}