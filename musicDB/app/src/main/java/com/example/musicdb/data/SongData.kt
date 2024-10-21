package com.example.musicdb.data

import androidx.compose.ui.graphics.Color
import com.example.musicdb.model.Song
import com.example.musicdb.ui.theme.Blue50900
import com.example.musicdb.ui.theme.Green50900
import com.example.musicdb.ui.theme.Red50900
import kotlin.random.Random

data class SongData (
    val id: Int = Random.nextInt(),
    val title: String = "",
    val group: String = "",
    val favourite: Boolean = false,
    val musicType: MusicType = Rock
) {
    companion object {
        fun fromEntity(entity: Song): SongData {
            return SongData(
                id = entity.id!!,
                title = entity.title,
                group = entity.group,
                favourite = entity.favourite,
                musicType = MusicType.fromInt(entity.musicType)
            )
        }
    }
}

fun SongData.toEntity(): Song {
    val id = if (this.id == -1) null else this.id
    return Song(
        id = id,
        group = this.group,
        title = this.title,
        favourite = this.favourite,
        musicType = musicType.toInt()
    )
}

private fun MusicType.toInt(): Int =
    when (this) {
        Rock -> 0
        NonRock -> 1
        Indi -> 2
        Techno -> 3
    }

sealed class MusicType(val backgroundColor: Color, val foregroundColor: Color) {
    companion object {
        fun fromInt(musicType: Int): MusicType {
            return if (musicType == 0) Rock else NonRock
        }
    }
}

data object NonRock:MusicType(Red50900, Color.White)
data object Indi:MusicType(Red50900, Color.White)
data object Rock:MusicType(Green50900, Color.White)
data object Techno:MusicType(Blue50900, Color.White)