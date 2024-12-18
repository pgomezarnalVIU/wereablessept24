package com.example.animedb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animedb.data.animes
import com.example.animedb.screens.AnimeCard
import com.example.animedb.viewmodel.ListAnimeViewModel

//Interface para mostrar un listado de animes
@Composable
fun ListAnime(navController: NavController, animesVM: ListAnimeViewModel){
    //Layout para añadir elementos en la ventana
    Scaffold (
        modifier = Modifier.background(Color.White),
        //Añadimos el boton flotante
        floatingActionButton = {
            FloatingActionButton(
                //Evento para el click
                onClick = {navController.navigate(Screen.AddEditAnimeScreen.ruta)}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir Anime")
            }
        }
    )
    { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding))
        {
            //Variable observable que permite repintar nuestro Composable
            var valor: String by remember { mutableStateOf("") }
            //View utilizaba el Model
            //Sustituir por el View_Model
            //Observable sobre los datos de los anime
            //var animesLocal by remember { mutableStateOf(animes)}
            Text(
                text = "El contenido es ${valor}"
            )
            OutlinedTextField(
                value = valor,
                maxLines = 1,
                onValueChange = { valor = it }
            )
            LazyColumn(
                modifier =
                Modifier.fillMaxSize()
            ) {
                //Recoger datos del ViewModel
                animesVM.animesVM.value.forEach { anime ->
                    item {
                        AnimeCard(navController,anime) {
                            //Borrado de elemento
                            println("He borranod el anime")
                            //animes.remove(anime)
                            //El Delete lo tendra que hacer el ViewModel
                            //animesLocal = animesLocal.filter {it!=anime}.toMutableList()
                            animesVM.onDeleteAnime(anime)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
        //}
    }
}