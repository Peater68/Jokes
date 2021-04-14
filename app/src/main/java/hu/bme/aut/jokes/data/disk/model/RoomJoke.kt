package hu.bme.aut.jokes.data.disk.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.bme.aut.jokes.domain.model.Flag

@Entity(tableName = "joke")
data class RoomJoke(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val mode: RoomJokeMode,
    val category: String,
    val flags: List<Flag>,
    val safe: Boolean,
    val type: RoomJokeType,
    val joke: String? = null,
    val setup: String? = null,
    val delivery: String? = null,
)

enum class RoomJokeType {
    SINGLE,
    TWO_PART
}

enum class RoomJokeMode {
    LIKED,
    MY
}