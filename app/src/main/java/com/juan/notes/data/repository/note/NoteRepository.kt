package com.juan.notes.data.repository.note

import androidx.lifecycle.LiveData
import com.juan.notes.NoteApplication
import com.juan.notes.data.db.NoteDao
import com.juan.notes.data.models.Note
import com.juan.notes.data.models.NotesWithTasks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): LiveData<MutableList<Note>> {
        return noteDao.getAll()
    }

    fun getNoteWithTask(id: Long): LiveData<NotesWithTasks>{
        return noteDao.getNoteWithTasks(id)
    }

    fun getNote(id: Long): LiveData<Note> {
        return noteDao.loadById(id)
    }

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun updateNote(note: Note) = withContext(Dispatchers.IO){
        noteDao.update(note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.delete(note)
    }

}