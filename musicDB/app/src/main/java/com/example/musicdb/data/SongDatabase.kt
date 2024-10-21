package com.example.musicdb.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musicdb.model.Song

@Database(entities = [Song::class], version = 1)
abstract class SongDatabase : RoomDatabase() {

    abstract val dao:SongDAO

    companion object {
        const val DATABASE_NAME = "songs.db"
    }
}