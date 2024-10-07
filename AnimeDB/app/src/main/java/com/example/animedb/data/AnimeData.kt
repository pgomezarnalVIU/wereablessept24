package com.example.animedb.data

import androidx.compose.ui.graphics.Color
import com.example.animedb.ui.theme.Purple40
import com.example.animedb.ui.theme.Purple80
import com.example.animedb.ui.theme.Purple900
import com.example.animedb.ui.theme.PurpleGrey40
import com.example.animedb.ui.theme.PurpleGrey80


//Tipo de Anime
enum class AnimeType (val backgroundColor:Color, val foregroundColor:Color){
    FANTASIA(Purple80, PurpleGrey40),
    DEPORTES(Purple40, PurpleGrey80),
    CIENCIAFICC(Purple900,Color.White)
}

//Data class, clase usada en Kotlin para definir datos
data class Anime(
    val titulo:String="",
    val creador:String="",
    val año:Int=0,
    val vista:Boolean=false,
    val animeType: AnimeType=AnimeType.FANTASIA
)

//Estos datos deberían alcanzarse desde un ApiRestFul
//Ahora se puede modificar la lista
val animes= mutableListOf(
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime("Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime("Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime("Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
)