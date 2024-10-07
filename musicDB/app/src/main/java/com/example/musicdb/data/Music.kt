package com.example.musicdb.data

import androidx.compose.ui.graphics.Color
import com.example.musicdb.ui.theme.Blue50900
import com.example.musicdb.ui.theme.Green50900
import com.example.musicdb.ui.theme.Red50900
import kotlin.random.Random

data class Music (
    val id: Int = Random.nextInt(),
    val title: String = "",
    val group: String = "",
    val favourite: Boolean = true,
    val musicType: MusicType = Rock
)

sealed class MusicType(val backgroundColor: Color, val foregroundColor: Color)
data object Indi:MusicType(Red50900, Color.White)
data object Rock:MusicType(Green50900, Color.White)
data object Techno:MusicType(Blue50900, Color.White)