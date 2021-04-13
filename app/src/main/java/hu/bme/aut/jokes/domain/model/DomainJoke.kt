package hu.bme.aut.jokes.domain.model

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