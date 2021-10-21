package com.juan.notes.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "Description") var description: String? = "",
    @ColumnInfo(name = "Done") var done: Boolean = false,
    @ColumnInfo(name = "IdNote") var idNote: Int
)
