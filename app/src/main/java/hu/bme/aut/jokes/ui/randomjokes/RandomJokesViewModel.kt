package hu.bme.aut.jokes.ui.randomjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class RandomJokesViewModel @Inject constructor(
    private val randomJokesPresenter: RandomJokesPresenter
) : RainbowCakeViewModel<RandomJokesViewState>(Loading) {

    fun load() = execute {
        viewState = RandomJokesReady(randomJokesPresenter.getData())
    }

}