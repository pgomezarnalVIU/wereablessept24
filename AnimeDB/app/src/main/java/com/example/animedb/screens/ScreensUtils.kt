package com.example.animedb.screens

sealed class Screen(val ruta:String){
    data object AnimeListScreen : Screen("lista_anime_screen")
    data object AddEditAnimeScreen : Screen ("add_edit_anime_screen")
}