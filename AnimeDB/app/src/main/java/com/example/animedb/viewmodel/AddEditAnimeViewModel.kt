package com.example.animedb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.animedb.data.Anime
import com.example.animedb.data.AnimeType

class AddEditAnimeViewModel : ViewModel() {

    //Variable en memoria que almacene la información de la lista de libros
    private val _anime = mutableStateOf(Anime())
    //Variable pública que usaremos para comunicar los cambios observador al UI
    var anime: State<Anime> = _anime

    init{
        //_anime.value = getAnime(animeId)
    }

    fun addCreador(creador:String){
        _anime.value = _anime.value.copy(creador=creador)
    }

    fun addTitulo(titulo:String){
        _anime.value = _anime.value.copy(titulo = titulo)
    }

    fun setType(type:AnimeType){
        _anime.value = _anime.value.copy(animeType = type)
    }
}