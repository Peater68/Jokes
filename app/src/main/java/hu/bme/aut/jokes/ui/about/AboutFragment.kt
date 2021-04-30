package hu.bme.aut.jokes.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import hu.bme.aut.jokes.R
import hu.bme.aut.jokes.databinding.FragmentAboutBinding
import hu.bme.aut.jokes.ui.common.ViewBindingFragment
import hu.bme.aut.jokes.util.addAboutIcon
import hu.bme.aut.jokes.util.removeAboutIcon
import hu.bme.aut.jokes.util.setToolbarTitle
import hu.bme.aut.jokes.util.setupBackNavigation

class AboutFragment : ViewBindingFragment<FragmentAboutBinding, AboutViewState, AboutViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAboutBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(R.string.about_screen_title)
        setupBackNavigation()
        removeAboutIcon()
        setupOkButton()
    }

    private fun setupOkButton() {
        binding.okButton.setOnClickListener {
            navigator?.pop()
        }
    }

    override fun onDestroyView() {
        addAboutIcon()
        super.onDestroyView()
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: AboutViewState) {
        when (viewState) {
            is AboutContent -> {
                binding.aboutText.text = viewState.aboutInfo
            }
            Loading -> Unit
        }
    }
}