package com.juan.notes.di

import android.app.Application
import androidx.room.Room
import com.juan.notes.data.db.NoteDao
import com.juan.notes.data.db.NotesDataBase
import com.juan.notes.data.db.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Singleton
    @Provides
    fun providesTasksDataBase(
        app: Application
    ): NotesDataBase{
        return Room.databaseBuilder(
            app,
            NotesDataBase::class.java,
            "TasksDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun provideNotesDao(notesDataBase: NotesDataBase): NoteDao{
        return notesDataBase.noteDao()
    }

    @Singleton
    @Provides
    fun provideTaskDao(notesDataBase: NotesDataBase): TaskDao{
        return notesDataBase.taskDao()
    }

}