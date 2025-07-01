package com.openclassrooms.notes.module

import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalNotesApiModule {
    @Provides
    @Singleton
    fun provideNotesApiService(): NotesApiService {
        return LocalNotesApiService()
    }

    @Provides
    @Singleton
    fun provideNotesRepository(notesApiService: NotesApiService): NotesRepository {
        return NotesRepository(notesApiService)
    }
}
