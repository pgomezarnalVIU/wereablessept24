package com.example.musicdb.interfaces.addedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import androidx.navigation.NavHostController
import com.example.musicdb.R
import com.example.musicdb.data.Indi
import com.example.musicdb.data.Rock
import com.example.musicdb.data.utils.Screen
import com.example.musicdb.interfaces.components.HorizontalTextRadioButton

@Composable
fun AddEditMusicScreen(
    navController: NavHostController,
    viewModel: AddEditMusicViewModel
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditMusicEvent.SaveMusic)
                    navController.navigate(Screen.MusicListScreen.route)
                },
            )
            {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save book")
            }
        }
    ) { contentPadding ->
        val song = viewModel.song.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(color = song.musicType.backgroundColor)
        ) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = stringResource(id = R.string.add_edit_song),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = song.group,
                label = { Text("Group") },
                onValueChange = {
                    viewModel.onEvent(AddEditMusicEvent.EnteredGroup(it))
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = song.musicType.foregroundColor),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = song.title,
                label = { Text("Title") },
                onValueChange = {
                    viewModel.onEvent(AddEditMusicEvent.EnteredTitle(it))
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = song.musicType.foregroundColor),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Favourite",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.headlineMedium.copy(color = song.musicType.foregroundColor),
                )
                Checkbox(
                    checked = song.favourite,
                    onCheckedChange = {
                        viewModel.onEvent(AddEditMusicEvent.MusicFavourite)
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {

                HorizontalTextRadioButton(
                    selected = song.musicType::class == Rock::class,
                    text = "Rock",
                    color = song.musicType.foregroundColor,
                    onOptionSelected = {
                        viewModel.onEvent(AddEditMusicEvent.TypeChanged(Rock))
                    })
                HorizontalTextRadioButton(
                    selected = song.musicType::class != Rock::class,
                    text = "Other",
                    color = song.musicType.foregroundColor,
                    onOptionSelected = {
                        viewModel.onEvent(AddEditMusicEvent.TypeChanged(Indi))
                    })
            }
        }
    }
}


