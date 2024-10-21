package com.example.musicdb.interfaces.addedit

import com.example.musicdb.data.SongDAO
import com.example.musicdb.model.Song
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeDatabase : SongDAO{

    val songs = mutableListOf<Song>()

    override fun getSongs(): Flow<List<Song>> = flow {
        emit(songs)
    }

    override suspend fun getSong(id: Int): Song? {
        return songs.find { it.id == id }
    }

    override suspend fun upsertSong(song: Song) {
        if(songs.contains(song))
            songs.remove(song)

        songs.add(song)
    }

    override suspend fun deleteSong(song: Song) {
        songs.remove(song)
    }
}