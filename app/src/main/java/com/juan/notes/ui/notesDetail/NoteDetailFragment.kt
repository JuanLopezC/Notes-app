package com.juan.notes.ui.notesDetail

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.juan.notes.R
import com.juan.notes.data.models.Note
import com.juan.notes.databinding.FragmentNoteDetailBinding
import com.juan.notes.ui.MainActivity
import com.juan.notes.ui.notesList.NoteViewModel
import com.juan.notes.ui.notesList.NotesListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding
    private val noteViewModel: NoteDetailViewModel by viewModels()

    private lateinit var note: Note
    private var noteId: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        arguments?.let {
            noteId = it.getLong("id_note")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)

        setUpViewModel()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        hideKeyboard()
        return when(item.itemId){
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            R.id.action_save -> {
                note.title = binding.etTitle.text.toString()
                note.description = binding.etDescription.text.toString()
                noteViewModel.insertNote(note)
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpViewModel() {
        if(noteId != 0L){
            noteViewModel.getNote(noteId).observe(viewLifecycleOwner, {
                note = it
                binding.etTitle.setText(it.title)
                binding.etDescription.setText(it.description)
            })
        } else {
            note = Note()
        }

    }

    private fun hideKeyboard() {
        activity?.currentFocus?.let {
            val imn = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imn?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

}