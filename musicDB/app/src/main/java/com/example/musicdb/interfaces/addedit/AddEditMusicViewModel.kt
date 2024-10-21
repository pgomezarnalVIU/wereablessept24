package com.example.musicdb.interfaces.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicdb.data.SongDAO
import com.example.musicdb.data.SongData
import com.example.musicdb.data.toEntity
import com.example.musicdb.data.utils.addOrUpdateSong
import com.example.musicdb.data.utils.getSongs
import com.example.musicdb.interfaces.components.SortByGroup
import kotlinx.coroutines.launch

class AddEditMusicViewModel(val dao: SongDAO, musicId: Int = -1) : ViewModel() {

    private val _song = mutableStateOf(SongData())
    val song: State<SongData> = _song

    private fun findSong(musicId: Int) {
        viewModelScope.launch {
            val songEntity = dao.getSong(musicId)
            _song.value = songEntity?.let { SongData.fromEntity (it)} ?: SongData()
        }

        //_song.value = getSongs(SortByGroup).find { it.id == musicId } ?: SongData()
    }

    init {
        findSong(musicId)
    }

    fun onEvent(event: AddEditMusicEvent) {
        when (event) {
            is AddEditMusicEvent.EnteredGroup -> {
                _song.value = _song.value.copy(group = event.group)
            }

            is AddEditMusicEvent.EnteredTitle -> {
                _song.value = _song.value.copy(title = event.title)
            }

            AddEditMusicEvent.MusicFavourite -> _song.value = _song.value.copy(favourite = !_song.value.favourite)
            is AddEditMusicEvent.TypeChanged -> {
                _song.value = _song.value.copy(musicType = event.musicType)
            }

            AddEditMusicEvent.SaveMusic -> {
                viewModelScope.launch {
                    val entity = song.value.toEntity()
                    dao.upsertSong(entity)
                }

                //addOrUpdateSong(song.value)
            }

        }

    }
}

