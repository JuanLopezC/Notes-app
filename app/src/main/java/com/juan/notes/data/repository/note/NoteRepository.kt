package com.juan.notes.data.repository.note

import androidx.lifecycle.LiveData
import com.juan.notes.data.db.NoteDao
import com.juan.notes.data.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): LiveData<MutableList<Note>> {
        return noteDao.getAll()
    }

    fun getNote(id: Long): LiveData<Note> {
        return noteDao.loadById(id)
    }

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.delete(note)
    }

}