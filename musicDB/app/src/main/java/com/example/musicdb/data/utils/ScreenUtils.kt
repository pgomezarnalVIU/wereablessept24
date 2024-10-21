package com.example.musicdb.data.utils

sealed class Screen (val route: String){
    data object MusicListScreen : Screen("music_list_screen")
    data object AddEditMusicScreen : Screen("add_edit_music_screen")
}