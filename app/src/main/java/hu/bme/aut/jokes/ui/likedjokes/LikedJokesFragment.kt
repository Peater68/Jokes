package hu.bme.aut.jokes.ui.likedjokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.jokes.databinding.FragmentLikedJokesBinding
import hu.bme.aut.jokes.ui.common.ViewBindingFragment

class LikedJokesFragment :
    ViewBindingFragment<FragmentLikedJokesBinding, LikedJokesViewState, LikedJokesViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLikedJokesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO Setup views
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: LikedJokesViewState) {
        // TODO Render state
    }
}