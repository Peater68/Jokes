package hu.bme.aut.jokes.ui.randomjokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.FragmentRandomJokesBinding
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.CONTENT_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.ERROR_STATE
import hu.bme.aut.jokes.ui.common.JokesViewAnimator.LOADING_STATE
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.ui.common.adapter.JokesAdapter
import hu.bme.aut.jokes.util.hideKeyboard
import hu.bme.aut.jokes.util.setToolbarTitle

class RandomJokesFragment :
    ViewBindingFragment<FragmentRandomJokesBinding, RandomJokesViewState, RandomJokesViewModel>() {

    private lateinit var adapter: JokesAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRandomJokesBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(R.string.random_jokes_screen_title)
        setupSearchView()
        setupListAdapter()
    }

    private fun setupListAdapter() {
        adapter = JokesAdapter(requireContext()) {
            viewModel.likeJoke(it)
        }
        binding.jokesLayout.jokeList.adapter = adapter
    }

    private fun setupSearchView() = with(binding.jokeCategoriesAutoCompleteText) {
        onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedCategory =
                    adapter.getItem(position) as String

                viewModel.getJokesForCategory(selectedCategory)
                hideKeyboard()
            }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: RandomJokesViewState) {
        when (viewState) {
            is Loading -> {
                binding.jokesLayout.viewAnimator.displayedChild = LOADING_STATE
            }
            is Error -> {
                binding.jokesLayout.viewAnimator.displayedChild = ERROR_STATE
            }
            is RandomJokesContent -> {
                setupFilterSpinnerContent(viewState.categories)
                setupContentState(viewState)
                binding.jokesLayout.viewAnimator.displayedChild = CONTENT_STATE
            }
        }
    }

    private fun setupContentState(viewState: RandomJokesContent) = with(binding) {
        jokeCategoriesAutoCompleteText.setText(viewState.searchedCategory)
        adapter.submitList(viewState.jokes)
    }

    private fun setupFilterSpinnerContent(categories: List<String>) {
        ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            categories
        ).also {
            it.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

            binding.jokeCategoriesAutoCompleteText.setAdapter(it)
        }
    }
}