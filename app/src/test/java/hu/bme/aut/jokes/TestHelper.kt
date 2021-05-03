package hu.bme.aut.jokes

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.robolectric.shadows.ShadowLog

@ExperimentalCoroutinesApi
val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        return DaggerTestComponent.builder().build()
    }