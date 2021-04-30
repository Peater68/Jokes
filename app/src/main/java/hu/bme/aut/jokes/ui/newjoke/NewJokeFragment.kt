package hu.bme.aut.jokes.ui.newjoke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.google.android.material.checkbox.MaterialCheckBox
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.FragmentNewJokeBinding
import hu.bme.aut.jokes.domain.model.Flag
import hu.bme.aut.jokes.domain.model.Flag.*
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.ui.newjoke.NewJokeViewModel.JokeSaved
import hu.bme.aut.jokes.util.clearFocus
import hu.bme.aut.jokes.util.setToolbarTitle
import hu.bme.aut.jokes.util.setupBackNavigation

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
        setupBackNavigation()
        with(binding) {
            nsfwCheckBox.setFlagCheckChangeListener(NSFW)
            religiousCheckBox.setFlagCheckChangeListener(RELIGIOUS)
            politicalCheckBox.setFlagCheckChangeListener(POLITICAL)
            racistCheckBox.setFlagCheckChangeListener(RACIST)
            sexistCheckBox.setFlagCheckChangeListener(SEXIST)
            explicitCheckBox.setFlagCheckChangeListener(EXPLICIT)

            isSafeSwitch.setOnCheckedChangeListener { _, isChecked ->
                clearFocus()
                viewModel.saveIsSafeToState(isChecked)
            }

            jokeInput.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus.not()) {
                    viewModel.saveJokeToState(jokeInput.text.toString())
                }
            }

            categorySpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        clearFocus()
                        val selectedCategory =
                            categorySpinner.adapter.getItem(position) as String

                        viewModel.saveSelectedCategoryToState(selectedCategory)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) = Unit
                }

            submitButton.setOnClickListener {
                clearFocus()
                viewModel.submitJoke()
            }
        }

    }

    private fun MaterialCheckBox.setFlagCheckChangeListener(flag: Flag) {
        setOnCheckedChangeListener { _, isChecked ->
            this@NewJokeFragment.clearFocus()
            viewModel.saveFlagToState(flag, isChecked)
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun onEvent(event: OneShotEvent) {
        when (event) {
            is JokeSaved -> {
                navigator?.pop()
            }
        }
    }

    override fun render(viewState: NewJokeViewState) {
        when (viewState) {
            is Loading -> Unit
            is NewJokeContent -> {
                binding.isSafeSwitch.isChecked = viewState.isSafe
                binding.jokeInput.setText(viewState.joke)
                setupFlags(viewState)
                setupCategorySpinner(viewState)
            }
        }
    }

    private fun setupFlags(viewState: NewJokeContent) = with(binding) {
        nsfwCheckBox.isChecked = viewState.selectedFlags.contains(NSFW)
        religiousCheckBox.isChecked = viewState.selectedFlags.contains(RELIGIOUS)
        politicalCheckBox.isChecked = viewState.selectedFlags.contains(POLITICAL)
        racistCheckBox.isChecked = viewState.selectedFlags.contains(RACIST)
        sexistCheckBox.isChecked = viewState.selectedFlags.contains(SEXIST)
        explicitCheckBox.isChecked = viewState.selectedFlags.contains(EXPLICIT)
    }

    private fun setupCategorySpinner(viewState: NewJokeContent) = with(binding.categorySpinner) {
        ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            viewState.categories,
        ).also {
            it.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

            adapter = it
        }
        setSelection(viewState.categories.indexOf(viewState.selectedCategory))
    }
}