package hu.bme.aut.jokes.mock

import hu.bme.aut.jokes.data.disk.dao.JokeDao
import hu.bme.aut.jokes.data.disk.model.RoomJoke
import hu.bme.aut.jokes.data.disk.model.RoomJokeMode

class MockJokeDao : JokeDao {
    override suspend fun insertJoke(joke: RoomJoke): Long {
        TODO("Not yet implemented")
    }

    override suspend fun getJokesByMode(mode: RoomJokeMode): List<RoomJoke> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteJokeById(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllJokes() {
        TODO("Not yet implemented")
    }
}