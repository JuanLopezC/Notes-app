package com.juan.notes.data.repository.task

import androidx.lifecycle.LiveData
import com.juan.notes.data.db.TaskDao
import com.juan.notes.data.models.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    fun getAllTasksByNoteId(idNote: Long): LiveData<MutableList<Task>>{
        return taskDao.loadByNoteId(idNote)
    }

    suspend fun insertTask(task: Task){
        taskDao.insert(task)
    }

    suspend fun updateTask(task: Task){
        taskDao.update(task)
    }

    suspend fun deleteTask(task: Task){
        taskDao.delete(task)
    }
}