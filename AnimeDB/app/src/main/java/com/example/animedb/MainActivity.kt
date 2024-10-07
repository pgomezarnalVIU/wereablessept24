package com.example.animedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animedb.screens.AnimeCard
import com.example.animedb.screens.ListAnime
import com.example.animedb.ui.theme.AnimeDBTheme
import com.example.animedb.data.animes
import com.example.animedb.screens.AddEditAnime
import com.example.animedb.viewmodel.ListAnimeViewModel
import com.example.animedb.screens.Screen
import com.example.animedb.viewmodel.AddEditAnimeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.safeDrawingPadding()) { innerPadding ->
                    //Creamos el controlador de navegacion
                    val navController = rememberNavController()

                    //Creamos en NavHost
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AnimeListScreen.ruta,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        //Configuramos la primera pantalla
                        composable(Screen.AnimeListScreen.ruta) {
                            //Creamos nuestro Viewmodel
                            val animesVM = viewModel<ListAnimeViewModel>()
                            //Lista de Animes
                            ListAnime(navController,animesVM);
                        }
                        //Configuramos la ruta hacia el add/edit
                        composable(Screen.AddEditAnimeScreen.ruta) {
                            //Creamos nuestro Viewmodel
                            val animeVM = viewModel<AddEditAnimeViewModel>()
                            //Lista de Animes
                            AddEditAnime(navController,animeVM);
                        }
                    }




                }
            }
        }
    }
}



