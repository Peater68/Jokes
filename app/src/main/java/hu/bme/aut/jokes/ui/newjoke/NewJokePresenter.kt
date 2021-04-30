package hu.bme.aut.jokes.ui.newjoke

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import hu.bme.aut.jokes.domain.model.DomainSingleJoke
import hu.bme.aut.jokes.domain.model.Flag
import java.util.*
import javax.inject.Inject

class NewJokePresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getCategories() = withIOContext {
        jokesInteractor.getCategories().filter { it.toLowerCase(Locale.getDefault()) != "any" }
    }

    suspend fun submitJoke(
        category: String,
        joke: String,
        safe: Boolean,
        flags: List<Flag>
    ) = withIOContext {
        jokesInteractor.saveMyJoke(
            DomainSingleJoke(
                id = 0L,
                category = category,
                joke = joke,
                safe = safe,
                flags = flags,
            )
        )
    }

}