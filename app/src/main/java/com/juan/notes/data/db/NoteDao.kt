package com.juan.notes.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.juan.notes.data.models.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): LiveData<MutableList<Note>>

    @Query("SELECT * FROM note WHERE id = (:noteId)")
    fun loadById(noteId: Long): LiveData<Note>

    @Insert
    suspend fun insert(vararg note: Note)

    @Delete
    suspend fun delete(note: Note)
}