package hu.bme.aut.jokes.ui.likedjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class LikedJokesViewModel @Inject constructor(
    private val likedJokesPresenter: LikedJokesPresenter
) : RainbowCakeViewModel<LikedJokesViewState>(Loading) {

    fun load() = execute {
        viewState = LikedJokesReady(likedJokesPresenter.getData())
    }

}