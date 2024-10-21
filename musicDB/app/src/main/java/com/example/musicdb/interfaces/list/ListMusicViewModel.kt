package com.example.musicdb.interfaces.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicdb.data.SongDAO
import com.example.musicdb.data.SongData
import com.example.musicdb.data.toEntity
import com.example.musicdb.data.utils.getSongs
import com.example.musicdb.interfaces.components.MusicEvent
import com.example.musicdb.interfaces.components.SortByGroup
import com.example.musicdb.interfaces.components.SortOrder
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ListMusicViewModel(val dao:SongDAO) : ViewModel() {
    private val _songs: MutableState<List<SongData>> = mutableStateOf(emptyList())
    var songs: State<List<SongData>> = _songs

    private var _sortOrder: MutableState<SortOrder> = mutableStateOf(SortByGroup)
    var sortOrder: State<SortOrder> = _sortOrder

    //Job para realizar la interacción con la BBDD con corrutinas
    var job: Job? = null

    init {
        loadMusic(sortOrder.value)
        _songs.value=getSongs(sortOrder.value)
    }

    private  fun loadMusic(sortOrder: SortOrder) {
        job?.cancel()

        job = dao.getSongs().onEach { songs->
            delay(5000)
            _songs.value = songs.map{
                SongData.fromEntity(it)
            }
        }.launchIn(viewModelScope)
        // carga datos desde memoria
        // return getSongs(sortOrder)

    }

    fun onEvent(event: MusicEvent) {
        when(event) {
            is MusicEvent.Delete -> {deleteSong(event.songData)}
            is MusicEvent.Order -> {
                _sortOrder.value = event.order
            }
        }
    }

    private fun deleteSong(song: SongData) {

        viewModelScope.launch {
            dao.deleteSong(song.toEntity())
        }

        //_songs.value = _songs.value.filter { it != song }
    }
}