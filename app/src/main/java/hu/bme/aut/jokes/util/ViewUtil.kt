package hu.bme.aut.jokes.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface ToolbarHandler {
    fun setTitle(title: String)
    fun setupBackNavigation()
    fun removeBackNavigation()
}

private val Fragment.toolbarHandler: ToolbarHandler?
    get() = activity as? ToolbarHandler

fun Fragment.setToolbarTitle(title: String) {
    toolbarHandler?.setTitle(title)
}

fun Fragment.setupBackNavigation() {
    toolbarHandler?.setupBackNavigation()
}

fun Fragment.removeBackNavigation() {
    toolbarHandler?.removeBackNavigation()
}

fun Fragment.setToolbarTitle(@StringRes titleRes: Int) {
    setToolbarTitle(getString(titleRes))
}

fun Activity.hideKeyboard() {
    currentFocus?.let { view ->
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
    clearFocus()
}

fun Fragment.clearFocus() {
    view?.clearFocus()
}

