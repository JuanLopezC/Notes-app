package com.juan.notes.ui.notesList

import androidx.recyclerview.selection.ItemKeyProvider

class NoteKeyProvider(private val adapter: NotesListAdapter) :
    ItemKeyProvider<Long>(SCOPE_CACHED) {
    override fun getKey(position: Int): Long? = adapter.currentList[position].id

    override fun getPosition(key: Long): Int = adapter.currentList.indexOfFirst { it.id == key }
}