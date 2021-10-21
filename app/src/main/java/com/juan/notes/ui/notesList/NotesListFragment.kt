package com.juan.notes.ui.notesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.juan.notes.data.models.Note
import com.juan.notes.databinding.FragmentNotesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesListFragment : Fragment() {

    private lateinit var binding: FragmentNotesListBinding
    private lateinit var listAdapter: NotesListAdapter
    private lateinit var gridLayout: GridLayoutManager
    private val noteViewModel: NoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotesListBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener { launchDetailNote(0) }

        setUpRecyclerView()
        setUpViewModel()

        return binding.root
    }


    private fun setUpViewModel(){
        noteViewModel.notesObserver.observe(viewLifecycleOwner,{ notesList ->
            listAdapter.submitList(notesList)
        })
    }

    private fun setUpRecyclerView(){
        listAdapter = NotesListAdapter()
        gridLayout = GridLayoutManager(context, 2)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = listAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        listAdapter.setOnClickListener { note ->  launchDetailNote(note.id) }

    }

    private fun launchDetailNote(id: Long){
        val action = NotesListFragmentDirections.actionTasksListFragmentToNoteDetailFragment(id)
        this.findNavController().navigate(action)
    }



}