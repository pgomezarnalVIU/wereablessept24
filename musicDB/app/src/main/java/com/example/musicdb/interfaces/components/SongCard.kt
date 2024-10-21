package com.example.musicdb.interfaces.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicdb.R
import com.example.musicdb.data.SongData


@Composable
fun SongCard(song: SongData, onDeleteClick: (SongData) -> Unit, modifier: Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = song.musicType.backgroundColor,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp)
            .then(modifier)
    ) {

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        song.title,
                        style = TextStyle(fontSize = 32.sp, color = song.musicType.foregroundColor),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (song.favourite) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = stringResource(id = R.string.delete),
                        tint = Color.White
                    )
                }
            }
            Text(
                song.group,
                style = TextStyle(fontSize = 32.sp, color = song.musicType.foregroundColor),
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = { onDeleteClick(song) },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.delete),
                tint = Color.White
            )
        }
    }
}