package hu.bme.aut.jokes.util

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import hu.bme.aut.jokes.ToolbarHandler

fun Fragment.setToolbarTitle(title: String) {
    (activity as? ToolbarHandler)?.setTitle(title)
}

fun Fragment.setToolbarTitle(@StringRes titleRes: Int) {
    setToolbarTitle(getString(titleRes))
}