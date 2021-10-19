package com.juan.notes.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.juan.notes.data.models.Note
import com.juan.notes.data.repository.note.NoteRepository
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(private val repository: NoteRepository) {

    operator fun invoke(id: Int): LiveData<Note> = liveData {
        val noteLiveData = repository.getNote(id)
        emitSource(noteLiveData)
    }
}