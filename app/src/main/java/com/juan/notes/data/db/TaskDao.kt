package com.juan.notes.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juan.notes.data.models.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): LiveData<MutableList<Task>>

    @Query("SELECT * FROM task WHERE idNote = (:noteId)")
    fun loadByNoteId(noteId: Long): LiveData<MutableList<Task>>

    @Update
    suspend fun update(vararg task: Task)

    @Insert
    suspend fun insert(vararg task: Task)

    @Delete
    suspend fun delete(task: Task)

}