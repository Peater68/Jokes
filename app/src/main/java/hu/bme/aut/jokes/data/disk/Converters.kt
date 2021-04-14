package hu.bme.aut.jokes.data.disk

import androidx.room.TypeConverter
import hu.bme.aut.jokes.data.disk.model.RoomJokeMode
import hu.bme.aut.jokes.data.disk.model.RoomJokeType
import hu.bme.aut.jokes.domain.model.Flag

object Converters {
    @TypeConverter
    fun flagListToString(value: List<Flag>): String {
        return value.joinToString(";") {
            it.name
        }
    }

    @TypeConverter
    fun stringToFlagList(value: String): List<Flag> {
        return value.split(";").map { Flag.valueOf(it) }
    }

    @TypeConverter
    fun jokeTypeToString(value: RoomJokeType): String {
        return value.name
    }

    @TypeConverter
    fun stringToJokeType(value: String): RoomJokeType {
        return RoomJokeType.valueOf(value)
    }

    @TypeConverter
    fun jokeModeToString(value: RoomJokeMode): String {
        return value.name
    }

    @TypeConverter
    fun stringToJokeMode(value: String): RoomJokeMode {
        return RoomJokeMode.valueOf(value)
    }
}