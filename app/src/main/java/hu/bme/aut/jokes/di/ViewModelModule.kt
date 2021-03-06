package hu.bme.aut.jokes.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.bme.aut.jokes.ui.about.AboutViewModel
import hu.bme.aut.jokes.ui.likedjokes.LikedJokesViewModel
import hu.bme.aut.jokes.ui.myjokes.MyJokesViewModel
import hu.bme.aut.jokes.ui.newjoke.NewJokeViewModel
import hu.bme.aut.jokes.ui.randomjokes.RandomJokesViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindBlankViewModel(aboutViewModel: AboutViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LikedJokesViewModel::class)
    abstract fun bindLikedJokesViewModel(likedJokesViewModel: LikedJokesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyJokesViewModel::class)
    abstract fun bindMyJokesViewModel(myJokesViewModel: MyJokesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RandomJokesViewModel::class)
    abstract fun bindRandomJokesViewModel(randomJokesViewModel: RandomJokesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewJokeViewModel::class)
    abstract fun bindNewJokeViewModel(newJokeViewModel: NewJokeViewModel): ViewModel
}