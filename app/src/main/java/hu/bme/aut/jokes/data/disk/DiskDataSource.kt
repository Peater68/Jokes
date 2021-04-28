package hu.bme.aut.jokes.data.disk

import hu.bme.aut.jokes.data.disk.dao.JokeDao
import hu.bme.aut.jokes.data.disk.model.RoomJoke
import hu.bme.aut.jokes.data.disk.model.RoomJokeMode
import hu.bme.aut.jokes.domain.model.DomainJoke
import hu.bme.aut.jokes.domain.model.toDomainJoke
import hu.bme.aut.jokes.domain.model.toRoomModel
import javax.inject.Inject

class DiskDataSource @Inject constructor(
    private val jokeDao: JokeDao
) {
    suspend fun saveLikedJoke(joke: DomainJoke) {
        jokeDao.insertJoke(joke.toRoomModel(RoomJokeMode.LIKED))
    }

    suspend fun saveMyJoke(joke: DomainJoke) {
        jokeDao.insertJoke(joke.toRoomModel(RoomJokeMode.MY))
    }

    suspend fun isJokeSaved(id: Long): Boolean {
        return jokeDao.getJokeById(id) != null
    }

    suspend fun getLikedJokes() = getJokes(RoomJokeMode.LIKED)

    suspend fun getMyJokes() = getJokes(RoomJokeMode.MY)

    private suspend fun getJokes(mode: RoomJokeMode) =
        jokeDao.getJokesByMode(mode).map(RoomJoke::toDomainJoke)

    suspend fun deleteJokeById(jokeId: Long) {
        jokeDao.deleteJokeById(jokeId)
    }

    suspend fun deleteAllJokes() {
        jokeDao.deleteAllJokes()
    }
}