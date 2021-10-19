package com.juan.notes.data.repository.note

import com.juan.notes.data.db.NoteDao
import com.juan.notes.data.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    suspend fun getAllTasks(): List<Note> {
        return withContext(Dispatchers.IO){
            noteDao.getAll()
        }
    }

     suspend fun insertTask(note: Note) {
        withContext(Dispatchers.IO){
            noteDao.insert(note)
        }
    }

}