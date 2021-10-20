package com.juan.notes.ui.notesList

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juan.notes.R
import com.juan.notes.data.models.Note
import com.juan.notes.databinding.NoteItemBinding

class NotesListAdapter :
    ListAdapter<Note, NotesListAdapter.ViewHolder>(NotesDiffCallback()) {

    var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = getItem(position)
        tracker?.let {
            holder.bind(note, it.isSelected(position.toLong()))
        }
    }

    override fun getItemId(position: Int): Long = position.toLong()



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = NoteItemBinding.bind(view)

        fun bind(note: Note, isActivated: Boolean) {
            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description
            binding.ivSelected.isVisible = isActivated

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(note)
                }
            }
        }

        fun getItemDetail(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int  = adapterPosition
                override fun getSelectionKey(): Long? = getItem(adapterPosition).id
                override fun inSelectionHotspot(e: MotionEvent): Boolean {
                    return true
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