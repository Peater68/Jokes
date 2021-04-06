package hu.bme.aut.jokes

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import hu.bme.aut.jokes.ui.about.AboutFragment
import hu.bme.aut.jokes.ui.likedjokes.LikedJokesFragment
import hu.bme.aut.jokes.ui.myjokes.MyJokesFragment
import hu.bme.aut.jokes.ui.randomjokes.RandomJokesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SimpleNavActivity(), ToolbarHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNav()

        if (savedInstanceState == null) {
            navigator.add(RandomJokesFragment())
        }
    }

    private fun setupBottomNav() {
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.randomJokes -> {
                    navigator.replace(RandomJokesFragment())
                }
                R.id.likedJokes -> {
                    navigator.replace(LikedJokesFragment())
                }
                R.id.myJokes -> {
                    navigator.replace(MyJokesFragment())
                }
            }
        }
    }

    private fun setupToolbar() {
        toolbar.inflateMenu(R.menu.toolbar_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.about -> {
                    navigator.add(AboutFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun setTitle(title: String) {
        toolbar.title = title
    }
}

interface ToolbarHandler {
    fun setTitle(title: String)
}
