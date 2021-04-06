package hu.bme.aut.jokes.ui.likedjokes

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class LikedJokesPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}