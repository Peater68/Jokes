package hu.bme.aut.jokes.ui.randomjokes.model

import hu.bme.aut.jokes.domain.model.DomainJoke
import hu.bme.aut.jokes.domain.model.DomainSingleJoke
import hu.bme.aut.jokes.domain.model.DomainTwoPartJoke
import hu.bme.aut.jokes.domain.model.Flag

data class Joke(
    val id: Long,
    val category: String,
    val joke: String,
    val flags: List<Flag>,
    val isLiked: Boolean = false,
)

fun DomainJoke.toUIModel(isLiked: Boolean): Joke {
    val joke = when (this) {
        is DomainSingleJoke -> this.joke
        is DomainTwoPartJoke -> "${this.setup}\n${this.delivery}"
    }
    return Joke(
        id = id,
        category = category,
        joke = joke,
        flags = flags,
        isLiked = isLiked,
    )
}
