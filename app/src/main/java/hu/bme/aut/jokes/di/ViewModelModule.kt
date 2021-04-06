package hu.bme.aut.jokes.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.bme.aut.jokes.ui.blank.BlankViewModel
import hu.bme.aut.jokes.ui.likedjokes.LikedJokesViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun bindBlankViewModel(blankViewModel: BlankViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LikedJokesViewModel::class)
    abstract fun bindLikedJokesViewModel(likedJokesViewModel: LikedJokesViewModel): ViewModel
}