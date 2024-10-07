package com.example.animedb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.animedb.components.HorizontalTextRadioButton
import com.example.animedb.data.AnimeType
import com.example.animedb.viewmodel.AddEditAnimeViewModel

//import com.example.animedb.viewmodel.AddEditAnimeViewModel

@Composable
fun AddEditAnime(
    navController: NavController,
    viewModel: AddEditAnimeViewModel
){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //viewModel.addEditAnime()
                    navController.navigate(Screen.AnimeListScreen.ruta)
                }
            )
            {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Salvar anime")
            }
        }
    ){ contentPadding ->
        val anime = viewModel.anime.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(color = anime.animeType.backgroundColor)
        ){
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = "Añadir/Editar Anime",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = anime.creador,
                label = { Text("Creador") },
                onValueChange = {
                    viewModel.addCreador(it)
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = anime.animeType.foregroundColor),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = anime.titulo,
                label = { Text("Titulo") },
                onValueChange = {
                    viewModel.addTitulo(it)
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = anime.animeType.foregroundColor),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Visto",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.headlineMedium.copy(color =anime.animeType.foregroundColor),
                )
                Checkbox(
                    checked = anime.vista,
                    onCheckedChange = {
                        //viewModel.visto()
                    }
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {

                HorizontalTextRadioButton(
                    selected = anime.animeType==AnimeType.FANTASIA,
                    text = "Fantasia",
                    color = anime.animeType.foregroundColor,
                    onOptionSelected = {
                        viewModel.setType(AnimeType.FANTASIA)
                    })
                HorizontalTextRadioButton(
                    selected = anime.animeType == AnimeType.DEPORTES,
                    text = "Deportes",
                    color = anime.animeType.foregroundColor,
                    onOptionSelected = {
                        viewModel.setType(AnimeType.DEPORTES)
                    })
                HorizontalTextRadioButton(
                    selected = anime.animeType == AnimeType.CIENCIAFICC,
                    text = "Ciencia Ficcion",
                    color = anime.animeType.foregroundColor,
                    onOptionSelected = {
                        viewModel.setType(AnimeType.CIENCIAFICC)
                    })
            }
        }
    }
}