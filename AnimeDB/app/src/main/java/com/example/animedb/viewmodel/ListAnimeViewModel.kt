package com.example.animedb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.animedb.data.Anime

import com.example.animedb.data.animes

class ListAnimeViewModel:ViewModel() {

    //Este combo es lo que tenemos disponible directamente en @Composable con by remember
    //Variable em memoria que almacena la lista de animes
    private val _animes:MutableState<List<Anime>> = mutableStateOf(emptyList())
    //Variable publica observable
    var animesVM: State<List<Anime>> = _animes

    init{
        //Cargar los datos
        _animes.value = animes
    }

    //Funcion de borrado
    fun onDeleteAnime(anime:Anime){
        _animes.value = _animes.value.filter {it!=anime}.toMutableList()
    }
}