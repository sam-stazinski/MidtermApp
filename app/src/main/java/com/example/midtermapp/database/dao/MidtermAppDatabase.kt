package com.example.midtermapp.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.midtermapp.database.entities.Score

// db/AppDatabase.kt

@Database(entities = [Score::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao

    companion object {
        // Singleton pattern to get the database instance.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "midterm_app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
