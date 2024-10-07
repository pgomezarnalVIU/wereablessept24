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
import com.example.animedb.screens.AnimeCard
import com.example.animedb.screens.ListAnime
import com.example.animedb.ui.theme.AnimeDBTheme
import com.example.animedb.data.animes
import com.example.animedb.viewmodel.ListAnimeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.safeDrawingPadding()) { innerPadding ->
                    //Creamos nuestro Viewmodel
                    val animesVM = viewModel<ListAnimeViewModel>()
                    //Lista de Animes
                    ListAnime(animesVM,innerPadding);
                }
            }
        }
    }
}



