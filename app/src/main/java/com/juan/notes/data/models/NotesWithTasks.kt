package com.juan.notes.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class NotesWithTasks(
    @Embedded val note: Note,
    @Relation(
        parentColumn = "id",
        entityColumn = "IdNote"
    )
    val tasksList: MutableList<Task>
)