package hu.bme.aut.jokes.ui.randomjokes.model

import androidx.recyclerview.widget.DiffUtil
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

object JokeComparator : DiffUtil.ItemCallback<Joke>() {
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke) = oldItem == newItem
}

fun DomainJoke.toUIModel(isLiked: Boolean): Joke {
    val joke = when (this) {
        is DomainSingleJoke -> this.joke
        is DomainTwoPartJoke -> "${this.setup}\n\n${this.delivery}"
    }
    return Joke(
        id = id,
        category = category,
        joke = joke,
        flags = flags,
        isLiked = isLiked,
    )
}
