package com.juan.notes.domain.usecase.notes

import com.juan.notes.data.models.Note
import com.juan.notes.data.repository.note.NoteRepository
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) = repository.insertNote(note)
}