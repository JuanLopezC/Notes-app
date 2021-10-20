package com.juan.notes.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "Title") var title: String?,
    @ColumnInfo(name = "Description") var description: String?
)
{
    constructor(): this(title = "", description = "" )
}