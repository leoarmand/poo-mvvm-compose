package com.openclassrooms.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.ui.theme.NotesTheme
import com.openclassrooms.notes.viewmodel.NoteItem
import com.openclassrooms.notes.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main activity for the app.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val noteViewModel: NoteViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(id = R.string.app_name))
                            }
                        )
                    },
                ) {
                    noteViewModel.Notes(
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
private fun NoteItemPreview() {
    NotesTheme(dynamicColor = false) {
        NoteItem(note = Note("Title", "Super loooooong description with a lot of words!"))
    }
}

