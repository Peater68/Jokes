package hu.bme.aut.jokes.ui.myjokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.FragmentMyJokesBinding
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.CONTENT_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.EMPTY_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.ERROR_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.LOADING_STATE
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.ui.common.adapter.JokesAdapter
import hu.bme.aut.jokes.ui.common.adapter.JokesAdapterType
import hu.bme.aut.jokes.ui.newjoke.NewJokeFragment
import hu.bme.aut.jokes.util.setToolbarTitle

class MyJokesFragment :
    ViewBindingFragment<FragmentMyJokesBinding, MyJokesViewState, MyJokesViewModel>() {

    private lateinit var adapter: JokesAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMyJokesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(R.string.my_jokes_screen_title)
        setupAddJokeButton()
        setupListAdapter()
    }

    private fun setupListAdapter() {
        adapter = JokesAdapter(
            context = requireContext(),
            type = JokesAdapterType.MY
        ) {
            viewModel.deleteJoke(it)
        }
        binding.jokesLayout.jokeList.adapter = adapter
    }

    private fun setupAddJokeButton() {
        binding.addJokeButton.setOnClickListener {
            navigator?.add(NewJokeFragment())
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: MyJokesViewState) {
        when (viewState) {
            is Loading -> {
                binding.jokesLayout.viewAnimator.displayedChild = LOADING_STATE
            }
            is Error -> {
                binding.jokesLayout.viewAnimator.displayedChild = ERROR_STATE
            }
            is MyJokesContent -> {
                if (viewState.jokes.isEmpty()) {
                    binding.jokesLayout.emptyLayout.emptyText.text =
                        getString(R.string.my_jokes_screen_empty_text)
                    binding.jokesLayout.viewAnimator.displayedChild = EMPTY_STATE
                } else {
                    adapter.submitList(viewState.jokes)
                    binding.jokesLayout.viewAnimator.displayedChild = CONTENT_STATE
                }

            }
        }
    }
}