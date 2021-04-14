package hu.bme.aut.jokes.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.bme.aut.jokes.data.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent : RainbowCakeComponent