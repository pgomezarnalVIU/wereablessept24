package com.example.animedb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animedb.data.Anime

//Interface para mostrar un listado de animes
@Composable
fun AnimeCard(navController: NavController, anime: Anime, onDeleteClick: (Anime)->Unit) {
    Box(
        modifier = Modifier
            .background(color=anime.animeType.backgroundColor, shape = RoundedCornerShape(5.dp))
            .fillMaxSize()
            //Hacer clickable todo el componente
            //Necesitaremos pasar el id para que lo reciba el AddEditAnime
            .clickable {
                navController.navigate(Screen.AddEditAnimeScreen.ruta+"?animeId=${anime.id}")
            }
    ){
        Column{
            //TITULO DE NUESTRO ANIME
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(anime.titulo,
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = anime.animeType.foregroundColor
                    ), maxLines = 2, overflow = TextOverflow.Ellipsis
                )
                //Añadir el icono de check
                if(anime.vista){
                    Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Anime visto", tint = Color.White)
                }
            }
            //CERADOR DE NUESTRO ANIME
            Text(anime.creador,
                style = TextStyle(
                    fontSize = 32.sp,
                    color = anime.animeType.foregroundColor
                ), maxLines = 1, overflow = TextOverflow.Ellipsis
                )
        }
        //Boton de borrado
        IconButton(
            onClick = {onDeleteClick(anime)},
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Borrado de anime", tint = Color.White)
        }
    }
}