package com.juan.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juan.notes.data.models.Note

@Database(
    entities = [
        Note::class
    ],
    version = 1
)
abstract class NotesDataBase: RoomDatabase() {
    abstract fun taskDao(): NoteDao
}