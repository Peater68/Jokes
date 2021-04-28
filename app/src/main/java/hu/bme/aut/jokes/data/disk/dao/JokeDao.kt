package hu.bme.aut.jokes.data.disk.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hu.bme.aut.jokes.data.disk.model.RoomJoke
import hu.bme.aut.jokes.data.disk.model.RoomJokeMode

@Dao
interface JokeDao {

    @Insert
    suspend fun insertJoke(joke: RoomJoke): Long

    @Query("SELECT * FROM joke WHERE id = :id")
    suspend fun getJokeById(id: Long): RoomJoke?

    @Query("SELECT * FROM joke WHERE mode = :mode")
    suspend fun getJokesByMode(mode: RoomJokeMode): List<RoomJoke>

    @Query("DELETE FROM joke WHERE id = :id")
    suspend fun deleteJokeById(id: Long)

    @Query("DELETE FROM joke")
    suspend fun deleteAllJokes()

}