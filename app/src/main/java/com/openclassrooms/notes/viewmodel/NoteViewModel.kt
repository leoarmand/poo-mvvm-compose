package com.openclassrooms.notes.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.openclassrooms.notes.R
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {

    @Composable
    fun Notes(
        modifier: Modifier = Modifier
    ) {
        val notes by notesRepository.notes.collectAsStateWithLifecycle(emptyList())

        LazyVerticalStaggeredGrid(
            modifier = modifier.fillMaxSize(),
            columns = StaggeredGridCells.Fixed(LocalContext.current.resources.getInteger(R.integer.span_count)),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(
                    items = notes,
                ) {
                    NoteItem(it)
                }
            }
        )
    }
}


@Composable
fun NoteItem(note: Note) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = note.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
