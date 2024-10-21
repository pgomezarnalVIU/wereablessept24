package com.example.musicdb.data.utils

import com.example.musicdb.data.Indi
import com.example.musicdb.data.SongData
import com.example.musicdb.data.Rock
import com.example.musicdb.data.Techno
import com.example.musicdb.interfaces.components.SortByFavourite
import com.example.musicdb.interfaces.components.SortByGroup
import com.example.musicdb.interfaces.components.SortByTitle
import com.example.musicdb.interfaces.components.SortByType
import com.example.musicdb.interfaces.components.SortOrder

/*
private val songDataLists: MutableList<SongData> = mutableListOf(
    SongData(id = 1, title = "1979", group = "smashing pumpkins", favourite = true,musicType=Indi),
    SongData(id = 2, title = "Sweet Child O' Mine", group = "Guns n' roses"),
    SongData(id = 3, title = "La Playa", group = "Los Planetas", favourite = true,musicType=Indi),
    SongData(id = 4, title = "Satisfaction", group = "Rolling Stone", favourite = false,musicType=Rock),
    SongData(id = 5, title = "In and out of love", group = "Armin van Buuren", favourite = false,musicType=Techno)
)
*/
private val songDataLists: MutableList<SongData> = mutableListOf(
    SongData(id = 1, title = "Sin titulo", group = "Esperando grupo", favourite = true,musicType=Indi),

)

fun getSongs(orderBy: SortOrder): List<SongData> {
    return when(orderBy) {
        SortByGroup -> songDataLists.sortedBy { it.group }
        SortByType -> songDataLists.sortedBy { it.musicType == Rock }
        SortByFavourite -> songDataLists.sortedBy { it.favourite }
        SortByTitle -> songDataLists.sortedBy { it.title }
    }
}

fun addOrUpdateSong(songData: SongData) {
    val existingAnime = songDataLists.find { it.id == songData.id }

    existingAnime?.let {
        songDataLists.remove(it)
    }
    songDataLists.add(songData)

}


fun deleteMusic(songData: SongData) {
    songDataLists.remove(songData)
}
