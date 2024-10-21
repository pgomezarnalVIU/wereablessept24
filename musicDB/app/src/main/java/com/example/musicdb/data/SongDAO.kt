package com.example.musicdb.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.musicdb.model.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDAO {

    @Query("SELECT * FROM songs")
    fun getSongs() : Flow<List<Song>>

    @Query("SELECT * FROM songs WHERE ID = :id")
    suspend fun getSong(id:Int) : Song?

    @Upsert
    suspend fun upsertSong(song : Song)

    @Delete
    suspend fun deleteSong(song : Song)
}