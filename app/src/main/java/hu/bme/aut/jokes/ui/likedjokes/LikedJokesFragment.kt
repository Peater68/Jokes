package hu.bme.aut.jokes.ui.likedjokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.LayoutJokesBinding
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.CONTENT_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.EMPTY_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.ERROR_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.LOADING_STATE
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.ui.common.adapter.JokesAdapter
import hu.bme.aut.jokes.util.setToolbarTitle

class LikedJokesFragment :
    ViewBindingFragment<LayoutJokesBinding, LikedJokesViewState, LikedJokesViewModel>() {

    private lateinit var adapter: JokesAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LayoutJokesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(R.string.liked_jokes_screen_title)
        setupListAdapter()
    }

    private fun setupListAdapter() {
        adapter = JokesAdapter(requireContext()) {
            viewModel.dislikeJoke(it)
        }
        binding.jokeList.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: LikedJokesViewState) {
        when (viewState) {
            is Loading -> {
                binding.viewAnimator.displayedChild = LOADING_STATE
            }
            is Error -> {
                binding.viewAnimator.displayedChild = ERROR_STATE
            }
            is LikedJokesContent -> {
                if (viewState.jokes.isEmpty()) {
                    binding.emptyLayout.emptyText.text =
                        getString(R.string.liked_jokes_screen_empty_text)
                    binding.viewAnimator.displayedChild = EMPTY_STATE
                } else {
                    adapter.submitList(viewState.jokes)
                    binding.viewAnimator.displayedChild = CONTENT_STATE
                }
            }
        }
    }
}