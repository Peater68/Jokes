package hu.bme.aut.jokes.domain.model

import hu.bme.aut.jokes.data.network.model.FlagsDto

enum class Flag {
    NSFW,
    RELIGIOUS,
    POLITICAL,
    RACIST,
    SEXIST,
    EXPLICIT,
}

fun FlagsDto.toDomainFlagList(): List<Flag> {
    return mutableListOf<Flag>().apply {
        if (nsfw) add(Flag.NSFW)
        if (religious) add(Flag.RELIGIOUS)
        if (political) add(Flag.POLITICAL)
        if (racist) add(Flag.RACIST)
        if (sexist) add(Flag.SEXIST)
        if (explicit) add(Flag.EXPLICIT)
    }
}