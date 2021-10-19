package com.juan.notes.ui.tasksList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.juan.notes.databinding.FragmentNotesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesListFragment : Fragment() {

    private lateinit var binding: FragmentNotesListBinding
    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotesListBinding.inflate(inflater, container, false)

        return binding.root
    }

    private fun setUpRecyclerView(){
        noteViewModel.tasks.observe(this){
            
        }
    }

}