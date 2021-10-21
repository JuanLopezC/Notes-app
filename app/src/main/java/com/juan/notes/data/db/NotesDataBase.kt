package com.juan.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juan.notes.data.models.Note
import com.juan.notes.data.models.Task

@Database(
    entities = [
        Note::class,
        Task::class
    ],
    version = 1
)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun taskDao(): TaskDao
}