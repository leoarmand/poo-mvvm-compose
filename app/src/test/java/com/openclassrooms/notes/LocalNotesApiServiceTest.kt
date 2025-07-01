package com.openclassrooms.notes

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LocalNotesApiServiceTest {
    private lateinit var service: LocalNotesApiService

    @Before
    fun setUp() {
        service = LocalNotesApiService()
    }

    @Test
    fun getAllNotes_returnsCorrectListOfNotes() {
        val notes = service.getAllNotes()

        Assert.assertTrue("La liste des notes ne devrait pas être vide", notes.isNotEmpty())

        Assert.assertEquals("La liste devrait contenir 10 notes", 10, notes.size)

        val expectedFirstNote = Note(
            "La vie est belle",
            "La vie est belle, pleine de choses à voir et à faire. Profitez de chaque moment et ne laissez jamais personne vous dire que vous ne pouvez pas faire ce que vous voulez."
        )
        val firstNote = notes[0]
        Assert.assertEquals(
            "Le titre de la première note ne correspond pas",
            expectedFirstNote.title,
            firstNote.title
        )
        Assert.assertEquals(
            "Le corps de la première note ne correspond pas",
            expectedFirstNote.body,
            firstNote.body
        )

        Assert.assertTrue("Tous les titres des notes ne devraient pas être vides", notes.all { it.title.isNotBlank() })
        Assert.assertTrue("Tous les corps des notes ne devraient pas être vides", notes.all { it.body.isNotBlank() })
    }
}
