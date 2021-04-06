package hu.bme.aut.jokes.ui.newjoke

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewJokeViewModel @Inject constructor(
    private val newJokePresenter: NewJokePresenter
) : RainbowCakeViewModel<NewJokeViewState>(Loading) {

    fun load() = execute {
        viewState = NewJokeReady(newJokePresenter.getData())
    }

}