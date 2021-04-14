package hu.bme.aut.jokes.data.disk

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DiskModule {
    companion object {
        private const val DB_NAME = "jokes.db"

        @Provides
        @Singleton
        fun provideJokesDatabase(context: Context): JokesDatabase {
            return Room.databaseBuilder(context, JokesDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        @Singleton
        fun provideJokeDao(jokesDatabase: JokesDatabase) = jokesDatabase.jokesDao()
    }
}