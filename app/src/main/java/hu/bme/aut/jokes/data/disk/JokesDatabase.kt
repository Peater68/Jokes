package hu.bme.aut.jokes.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.bme.aut.jokes.data.disk.dao.JokeDao
import hu.bme.aut.jokes.data.disk.model.RoomJoke

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        RoomJoke::class,
    ]
)
@TypeConverters(
    Converters::class
)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokesDao(): JokeDao
}