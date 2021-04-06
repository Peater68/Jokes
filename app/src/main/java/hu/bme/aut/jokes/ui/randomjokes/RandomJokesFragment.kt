package hu.bme.aut.jokes.ui.randomjokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.FragmentRandomJokesBinding
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.util.setToolbarTitle

class RandomJokesFragment :
    ViewBindingFragment<FragmentRandomJokesBinding, RandomJokesViewState, RandomJokesViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRandomJokesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(R.string.random_jokes_screen_title)
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: RandomJokesViewState) {
        // TODO Render state
    }
}