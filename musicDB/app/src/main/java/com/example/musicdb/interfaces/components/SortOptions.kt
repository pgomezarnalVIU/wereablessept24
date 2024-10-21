package com.example.musicdb.interfaces.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicdb.data.SongData

@Composable
fun SortOptions(
    musicOrder: SortOrder = SortByGroup,
    onSortOrderChange: (SortOrder) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        MusicRadioButton(text = "Group",
            selected = musicOrder is SortByGroup,
            onSelect = { onSortOrderChange(SortByGroup) })

        Spacer(modifier = Modifier.width(8.dp))

        MusicRadioButton(text = "Title",
            selected = musicOrder is SortByTitle,
            onSelect = { onSortOrderChange(SortByTitle) })

    }
    Spacer(modifier = Modifier.height(8.dp))
    Row() {

        MusicRadioButton(text = "Type",
            selected = musicOrder is SortByType,
            onSelect = { onSortOrderChange(SortByType) })

        Spacer(modifier = Modifier.width(8.dp))

        MusicRadioButton(text = "Favourite",
            selected = musicOrder is SortByFavourite,
            onSelect = { onSortOrderChange(SortByFavourite) })

    }
}

sealed class SortOrder()
data object SortByGroup : SortOrder()
data object SortByTitle : SortOrder()
data object SortByFavourite : SortOrder()
data object SortByType : SortOrder()


data class NotesState(
    val songDataList: List<SongData> = emptyList(),
    val musicOrder: SortOrder = SortByGroup,
)

sealed class MusicEvent {
    data class Order(val order: SortOrder) : MusicEvent()
    data class Delete(val songData: SongData) : MusicEvent()
}
