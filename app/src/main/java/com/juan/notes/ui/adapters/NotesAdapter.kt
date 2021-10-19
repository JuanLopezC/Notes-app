package com.juan.notes.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juan.notes.R
import com.juan.notes.data.models.Note
import com.juan.notes.databinding.NoteItemBinding

class NotesAdapter(private val notes: List<Note>): RecyclerView.Adapter<NotesAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = notes[position]
        holder.binding(task)
    }

    override fun getItemCount(): Int = notes.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = NoteItemBinding.bind(view)

       fun binding(note: Note){
           binding.tvTitle.text = note.title
           binding.tvDescription.text = note.description
           binding.root.setOnClickListener {
               onItemClickListener?.let {
                   it(note)
               }
           }
       }
    }

    var onItemClickListener: ((Note) -> Unit)? = null
    fun setOnClickListener(listener: (Note) -> Unit){
        onItemClickListener = listener
    }

}