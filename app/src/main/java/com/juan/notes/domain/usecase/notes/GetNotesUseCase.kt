package com.juan.notes.domain.usecase.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.juan.notes.data.models.Note
import com.juan.notes.data.repository.note.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor (private val repository: NoteRepository) {
//    suspend operator fun invoke():LiveData<List<Note>> = repository.getAllNotes()

    operator fun invoke(): LiveData<MutableList<Note>> = liveData {
        val noteLiveData = repository.getAllNotes()
        emitSource(noteLiveData)
    }
}