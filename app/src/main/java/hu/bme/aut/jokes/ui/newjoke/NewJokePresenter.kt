package hu.bme.aut.jokes.ui.newjoke

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class NewJokePresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}