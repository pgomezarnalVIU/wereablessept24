package com.example.musicdb.interfaces.list


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musicdb.R
import com.example.musicdb.data.utils.Screen
//import com.example.musicdb.data.utils.Screen
import com.example.musicdb.interfaces.components.MusicEvent
import com.example.musicdb.interfaces.components.SongCard
import com.example.musicdb.interfaces.components.SortOptions
import kotlinx.coroutines.launch


@Composable
fun ListMusicScreen(navController: NavController, songsViewModel: ListMusicViewModel) {

    val snackbarHostState = remember {SnackbarHostState()}
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost ={ SnackbarHost(snackbarHostState)},
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddEditMusicScreen.route)
            },
                modifier = Modifier.background(Color.White)) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a song")
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.main_heading),
                style = TextStyle(fontSize = 32.sp)
            )

            SortOptions(musicOrder = songsViewModel.sortOrder.value, onSortOrderChange = { order ->
                songsViewModel.onEvent(MusicEvent.Order(order))
            })

            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                songsViewModel.songs.value.forEach{ music ->
                    item{
                        SongCard(music, onDeleteClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Deleted song")
                            }
                            //Borrado de la cancion
                            songsViewModel.onEvent(MusicEvent.Delete(music))
                        },
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.AddEditMusicScreen.route + "?musicId=${music.id}")
                            })
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}