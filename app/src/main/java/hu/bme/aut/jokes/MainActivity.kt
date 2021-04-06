package hu.bme.aut.jokes

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity

class MainActivity : SimpleNavActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}