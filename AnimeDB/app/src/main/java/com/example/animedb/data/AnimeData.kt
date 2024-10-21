package com.example.animedb.data

import androidx.compose.ui.graphics.Color
import com.example.animedb.ui.theme.Purple40
import com.example.animedb.ui.theme.Purple80
import com.example.animedb.ui.theme.Purple900
import com.example.animedb.ui.theme.PurpleGrey40
import com.example.animedb.ui.theme.PurpleGrey80
import kotlinx.coroutines.flow.flow


//Tipo de Anime
enum class AnimeType (val backgroundColor:Color, val foregroundColor:Color){
    FANTASIA(Purple80, PurpleGrey40),
    DEPORTES(Purple40, PurpleGrey80),
    CIENCIAFICC(Purple900,Color.White)
}

//Data class, clase usada en Kotlin para definir datos
data class Anime(
    val id:Int=-1,
    val titulo:String="",
    val creador:String="",
    val año:Int=0,
    val vista:Boolean=false,
    val animeType: AnimeType=AnimeType.FANTASIA
)

//Estos datos deberían alcanzarse desde un ApiRestFul
//Ahora se puede modificar la lista
val animes= mutableListOf(
    Anime(id=1,"Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime(id=2,"Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime(id=3,"Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime(id=4,"Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime(id=5,"Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime(id=6,"Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES),
    Anime(id=7,"Bola de dragon", "Akira Toriyama", 1986, true, animeType = AnimeType.CIENCIAFICC),
    Anime(id=8,"Cyberpunk: Edgerunners", "Rafał Jaki", 2022, true, animeType = AnimeType.CIENCIAFICC),
    Anime(id=9,"Ataque a los Titanes", "Hajime Isayama", 2009, false, AnimeType.FANTASIA),
    Anime(id=10,"Haikyū!!", "Haruichi Furudate", 2012, false, AnimeType.DEPORTES)
)

//Funcion que simula un flow de datos
fun getAnimes() = flow {
    emit(animes)
}

//Get Anime con un id
fun getAnime(animeId:Int):Anime{
    return animes.find {it.id==animeId} ?: Anime()
}

fun addEditAnime(animeNew:Anime){

    val existingAnime = animes.find { it.id == animeNew.id }

    existingAnime?.let {
        animes.remove(it)
    }
    animes.add(animeNew)
}