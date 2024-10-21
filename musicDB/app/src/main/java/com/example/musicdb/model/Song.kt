package com.example.musicdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicdb.data.MusicType
import com.example.musicdb.data.Rock
import kotlin.random.Random

@Entity(tableName = "Songs")
data class Song (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String = "",
    val group: String = "",
    val favourite: Boolean = false,
    val musicType: Int
)
