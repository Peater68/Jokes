package hu.bme.aut.jokes.ui.about

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AboutViewModel @Inject constructor(
    private val aboutPresenter: AboutPresenter
) : RainbowCakeViewModel<AboutViewState>(Loading) {

    fun load() = execute {
        viewState = AboutContent(aboutPresenter.getAboutInfo())
    }

}