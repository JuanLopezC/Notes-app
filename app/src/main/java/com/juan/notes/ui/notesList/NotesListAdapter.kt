package com.juan.notes.ui.notesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juan.notes.R
import com.juan.notes.data.models.Note
import com.juan.notes.databinding.NoteItemBinding

class NotesListAdapter :
    ListAdapter<Note, RecyclerView.ViewHolder>(NotesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val note = getItem(position)
        with(holder as ViewHolder) {
            binding(note)
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = NoteItemBinding.bind(view)

        fun binding(note: Note) {
            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(note)
                }
            }
        }

    }

    class NotesDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    private var onItemClickListener: ((Note) -> Unit)? = null

    fun setOnClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }


}