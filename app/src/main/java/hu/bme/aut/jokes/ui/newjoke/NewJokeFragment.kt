package hu.bme.aut.jokes.ui.newjoke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.FragmentNewJokeBinding
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.util.setToolbarTitle

class NewJokeFragment :
    ViewBindingFragment<FragmentNewJokeBinding, NewJokeViewState, NewJokeViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewJokeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(R.string.new_joke_screen_title)
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: NewJokeViewState) {
        // TODO Render state
    }
}