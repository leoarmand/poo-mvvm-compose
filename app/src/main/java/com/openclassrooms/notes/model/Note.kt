package com.openclassrooms.notes.model

import java.io.Serializable

data class Note(
    val title: String,
    val body: String
): Serializable
