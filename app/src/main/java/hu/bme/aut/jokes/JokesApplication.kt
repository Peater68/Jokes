package hu.bme.aut.jokes

import co.zsmb.rainbowcake.config.Loggers
import co.zsmb.rainbowcake.config.rainbowCake
import co.zsmb.rainbowcake.dagger.RainbowCakeApplication
import co.zsmb.rainbowcake.timber.TIMBER
import hu.bme.aut.jokes.di.AppComponent
import hu.bme.aut.jokes.di.ApplicationModule
import hu.bme.aut.jokes.di.DaggerAppComponent
import timber.log.Timber

class JokesApplication : RainbowCakeApplication() {
    override lateinit var injector: AppComponent

    override fun setupInjector() {
        injector = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        rainbowCake {
            logger = Loggers.TIMBER
            isDebug = BuildConfig.DEBUG
            consumeExecuteExceptions = BuildConfig.DEBUG.not()
        }

        Timber.plant(Timber.DebugTree())
    }
}