package com.juan.notes.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juan.notes.data.models.Note
import com.juan.notes.data.models.NotesWithTasks

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): LiveData<MutableList<Note>>

    @Query("SELECT * FROM note WHERE id = (:noteId)")
    fun loadById(noteId: Long): LiveData<Note>

    @Query("SELECT * FROM note WHERE id = (:noteId)")
    fun getNoteWithTasks(noteId: Long): LiveData<NotesWithTasks>

    @Update
    suspend fun update(vararg note: Note)

    @Insert
    suspend fun insert(vararg note: Note)

    @Delete
    suspend fun delete(note: Note)
}