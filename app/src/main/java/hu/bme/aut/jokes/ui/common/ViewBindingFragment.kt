package hu.bme.aut.jokes.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.base.RainbowCakeViewModel

abstract class ViewBindingFragment<VB : ViewBinding, VS : Any, VM : RainbowCakeViewModel<VS>>
    : RainbowCakeFragment<VS, VM>() {

    private var _binding: VB? = null

    // This property is only valid between onCreateView and onDestroyView.
    protected val binding get() = _binding!!

    /**
     * Returns the result of `ViewBinding.inflate(inflater, container, attachToParent)` where
     * "ViewBinding" should be the supplied type of the VB generic parameter.
     **/
    abstract fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initViewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
