package hu.bme.aut.jokes.mock.disk

import hu.bme.aut.jokes.data.disk.dao.JokeDao
import hu.bme.aut.jokes.data.disk.model.RoomJoke
import hu.bme.aut.jokes.data.disk.model.RoomJokeMode
import hu.bme.aut.jokes.data.disk.model.RoomJokeType

class MockJokeDao : JokeDao {
    companion object {
        const val EXAMPLE_LIKED_JOKE_ID = 20L
        const val EXAMPLE_MY_JOKE_ID = 21L
        const val INVALID_JOKE_ID = -123L

        var jokes: MutableList<RoomJoke> = mutableListOf(
            RoomJoke(
                id = EXAMPLE_LIKED_JOKE_ID,
                mode = RoomJokeMode.LIKED,
                category = "Dark",
                flags = emptyList(),
                safe = true,
                type = RoomJokeType.SINGLE,
                joke = "joke",
                setup = null,
                delivery = null,
            ),
            RoomJoke(
                id = EXAMPLE_MY_JOKE_ID,
                mode = RoomJokeMode.MY,
                category = "Misc",
                flags = emptyList(),
                safe = true,
                type = RoomJokeType.SINGLE,
                joke = "joke",
                setup = null,
                delivery = null,
            )
        )
    }

    override suspend fun insertJoke(joke: RoomJoke): Long {
        val index = jokes.indexOfFirst { it.id == joke.id }
        if (index != -1) {
            jokes.removeAt(index)
        }
        jokes.add(joke)
        return joke.id
    }

    override suspend fun getJokeById(id: Long): RoomJoke? {
        return jokes.firstOrNull { it.id == id }
    }

    override suspend fun getJokesByMode(mode: RoomJokeMode): List<RoomJoke> {
        return jokes.filter { it.mode == mode }
    }

    override suspend fun deleteJokeById(id: Long) {
        jokes.removeIf { it.id == id }
    }

    override suspend fun deleteAllJokes() {
        jokes.clear()
    }

    override suspend fun deleteJokesByMode(mode: RoomJokeMode) {
        jokes.removeIf { it.mode == mode }
    }

    override suspend fun updateJokeMode(id: Long, mode: RoomJokeMode) {
        val index = jokes.indexOfFirst { it.id == id }
        if (index == -1) return
        jokes[index] = jokes[index].copy(mode = mode)
    }
}