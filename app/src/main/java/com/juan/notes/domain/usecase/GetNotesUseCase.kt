package com.juan.notes.domain.usecase

import com.juan.notes.data.models.Note
import com.juan.notes.data.repository.note.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor (private val repository: NoteRepository) {
    suspend operator fun invoke():List<Note> = repository.getAllTasks()
}