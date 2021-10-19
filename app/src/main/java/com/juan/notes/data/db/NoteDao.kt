package com.juan.notes.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.juan.notes.data.models.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE id = (:noteId)")
    suspend fun loadById(noteId: Int): Note

    @Insert
    suspend fun insert(vararg note: Note)

    @Delete
    suspend fun delete(note: Note)
}