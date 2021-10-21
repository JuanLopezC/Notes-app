package com.juan.notes.ui.notesDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.notes.data.models.Note
import com.juan.notes.domain.usecase.DeleteNoteUseCase
import com.juan.notes.domain.usecase.GetNoteByIdUseCase
import com.juan.notes.domain.usecase.InsertNoteUseCase
import com.juan.notes.domain.usecase.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {


    fun insertNote(note: Note) {
        viewModelScope.launch {
            insertNoteUseCase(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            updateNoteUseCase(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }

    fun getNote(id: Int): LiveData<Note> {
        return getNoteByIdUseCase(id)
    }
}