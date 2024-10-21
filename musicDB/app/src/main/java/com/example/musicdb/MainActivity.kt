package com.example.musicdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.musicdb.ui.theme.MusicDBTheme
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.musicdb.data.SongDatabase
import com.example.musicdb.data.utils.Screen
import com.example.musicdb.interfaces.addedit.AddEditMusicScreen
import com.example.musicdb.interfaces.addedit.AddEditMusicViewModel
import com.example.musicdb.interfaces.list.ListMusicScreen
import com.example.musicdb.interfaces.list.ListMusicViewModel

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            SongDatabase::class.java,
            SongDatabase.DATABASE_NAME
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.MusicListScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Screen.MusicListScreen.route) {
                            val songs = viewModel<ListMusicViewModel>{
                                ListMusicViewModel(db.dao)
                            }
                            ListMusicScreen(navController, songs)
                        }

                        composable(route = Screen.AddEditMusicScreen.route+"?musicId={musicId}",
                            arguments = listOf(
                                navArgument(name = "musicId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )) { navBackStackEntry ->

                            val musicId = navBackStackEntry.arguments?.getInt("musicId") ?: -1

                            val song = viewModel<AddEditMusicViewModel>() {
                                AddEditMusicViewModel(db.dao,musicId)
                            }
                            AddEditMusicScreen(navController, song)
                        }
                    }

                }
            }
        }
    }
}
