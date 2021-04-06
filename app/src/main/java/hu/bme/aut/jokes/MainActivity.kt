package hu.bme.aut.jokes

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SimpleNavActivity(), ToolbarHandler {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun setTitle(title: String) {
        toolbar.title = title
    }
}

interface ToolbarHandler {
    fun setTitle(title: String)
}
