package hu.bme.aut.jokes.ui.myjokes

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class MyJokesPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}