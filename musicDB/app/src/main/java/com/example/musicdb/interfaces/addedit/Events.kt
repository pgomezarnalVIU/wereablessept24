package com.example.musicdb.interfaces.addedit

import com.example.musicdb.data.MusicType


sealed interface AddEditMusicEvent {
    data class EnteredGroup(val group: String) : AddEditMusicEvent
    data class EnteredTitle(val title: String): AddEditMusicEvent
    data object MusicFavourite: AddEditMusicEvent
    data object SaveMusic: AddEditMusicEvent
    data class TypeChanged(val musicType: MusicType): AddEditMusicEvent
}