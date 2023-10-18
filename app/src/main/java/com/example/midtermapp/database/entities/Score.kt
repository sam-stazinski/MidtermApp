package com.example.midtermapp.database.entities

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name= "playerName") val playerName: Editable,
    @ColumnInfo(name= "numOfAttempts") val numOfAttempts: Int?
)