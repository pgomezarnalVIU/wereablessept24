package com.example.animedb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedb.data.Anime

import com.example.animedb.data.animes
import com.example.animedb.data.getAnimes
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListAnimeViewModel:ViewModel() {

    //Este combo es lo que tenemos disponible directamente en @Composable con by remember
    //Variable em memoria que almacena la lista de animes
    private val _animes:MutableState<List<Anime>> = mutableStateOf(emptyList())
    //Variable publica observable
    var animesVM: State<List<Anime>> = _animes

    init{
        //Capturar los datos desde elflujo de datos
        getAnimes().onEach {
            _animes.value=animes
        }.launchIn(viewModelScope)

        //Cargar los datos
        //_animes.value = animes
    }

    //Funcion de borrado
    fun onDeleteAnime(anime:Anime){
        _animes.value = _animes.value.filter {it!=anime}.toMutableList()
    }
}