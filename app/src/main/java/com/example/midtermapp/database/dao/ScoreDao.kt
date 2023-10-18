package com.example.midtermapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.midtermapp.database.entities.Score

@Dao
interface ScoreDao {
    @Query("SELECT * FROM score ORDER BY numOfAttempts ASC")
    fun getAllScores(): List<Score>

    @Insert
    fun insert(score: Score)

    @Delete
    fun delete(score: Score)
}