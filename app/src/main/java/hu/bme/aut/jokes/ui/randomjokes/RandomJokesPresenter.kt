package hu.bme.aut.jokes.ui.randomjokes

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class RandomJokesPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}