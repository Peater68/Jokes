package hu.bme.aut.jokes.ui.myjokes

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class MyJokesViewModel @Inject constructor(
    private val myJokesPresenter: MyJokesPresenter
) : RainbowCakeViewModel<MyJokesViewState>(Loading) {

    fun load() = execute {
        viewState = MyJokesReady(myJokesPresenter.getData())
    }

}