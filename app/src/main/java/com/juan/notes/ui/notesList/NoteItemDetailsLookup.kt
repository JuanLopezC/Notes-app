package com.juan.notes.ui.notesList

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class NoteItemDetailsLookup(private val recyclerView: RecyclerView): ItemDetailsLookup<Long>(){
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view = recyclerView.findChildViewUnder(e.x, e.y)
        if(view != null){
            return (recyclerView.getChildViewHolder(view) as NotesListAdapter.ViewHolder).getItemDetail()
        }
        return null
    }
}