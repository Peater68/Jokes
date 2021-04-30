package hu.bme.aut.jokes.mock.disk

import hu.bme.aut.jokes.data.disk.dao.JokeDao
import hu.bme.aut.jokes.data.disk.model.RoomJoke
import hu.bme.aut.jokes.data.disk.model.RoomJokeMode
import kotlin.random.Random

class MockJokeDao : JokeDao {
    companion object {
        var jokes: MutableList<RoomJoke> = mutableListOf()
    }

    override suspend fun insertJoke(joke: RoomJoke): Long {
        val randomId = Random.nextLong()
        jokes.add(joke.copy(id = randomId))
        return randomId
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