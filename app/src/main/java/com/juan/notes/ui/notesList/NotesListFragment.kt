package com.juan.notes.ui.notesList

import android.os.Bundle
import android.text.Selection
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
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
    private var tracker: SelectionTracker<Long>? = null
    private val noteViewModel: NoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotesListBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener { launchDetailNote(0) }
        val notesRv = binding.recyclerView

        setUpRecyclerView()
        setUpViewModel()



//        tracker?.addObserver(
//            object : SelectionTracker.SelectionObserver<Long>(){
//                override fun onSelectionChanged() {
//                    super.onSelectionChanged()
//                    val items = tracker?.selection!!.size()
//                }
//            }
//        )
        return binding.root
    }


    private fun setUpViewModel(){
        noteViewModel.getNotesList().observe(viewLifecycleOwner, {
            listAdapter.submitList(it)
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
//        listAdapter.setOnClickListener { note ->  launchDetailNote(note.id) }

        tracker = SelectionTracker.Builder<Long>(
            "mySelection",
            binding.recyclerView,
            NoteKeyProvider(listAdapter),
            NoteItemDetailsLookup(binding.recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        listAdapter.tracker = tracker

    }

    private fun launchDetailNote(id: Long){
        val action = NotesListFragmentDirections.actionTasksListFragmentToNoteDetailFragment(id)
        this.findNavController().navigate(action)
    }



}