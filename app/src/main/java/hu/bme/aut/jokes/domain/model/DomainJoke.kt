package hu.bme.aut.jokes.domain.model

import hu.bme.aut.jokes.data.network.model.JokeDto

sealed class DomainJoke {
    abstract val category: String
    abstract val flags: List<Flag>
    abstract val id: Long
    abstract val safe: Boolean
}

data class DomainSingleJoke(
    val joke: String,
    override val category: String,
    override val flags: List<Flag>,
    override val id: Long,
    override val safe: Boolean,
) : DomainJoke()

data class DomainTwoPartJoke(
    val setup: String,
    val delivery: String,
    override val category: String,
    override val flags: List<Flag>,
    override val id: Long,
    override val safe: Boolean,
) : DomainJoke()

fun JokeDto.toDomainJoke(): DomainJoke {
    return when (type) {
        JokeDto.Type.SINGLE -> DomainSingleJoke(
            id = id,
            safe = safe,
            category = category,
            flags = flags.toDomainFlagList(),
            joke = joke!!
        )
        JokeDto.Type.TWOPART -> DomainTwoPartJoke(
            id = id,
            safe = safe,
            category = category,
            flags = flags.toDomainFlagList(),
            setup = setup!!,
            delivery = delivery!!
        )
    }
}