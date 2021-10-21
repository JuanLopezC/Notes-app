package com.juan.notes.ui.notesDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.notes.data.models.Note
import com.juan.notes.domain.usecase.notes.DeleteNoteUseCase
import com.juan.notes.domain.usecase.notes.GetNoteByIdUseCase
import com.juan.notes.domain.usecase.notes.InsertNoteUseCase
import com.juan.notes.domain.usecase.notes.UpdateNoteUseCase
import com.juan.notes.domain.usecase.tasks.InsertTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val insertTaskUseCase: InsertTaskUseCase
) : ViewModel() {


    fun getNote(id: Long): LiveData<Note> {
        return getNoteByIdUseCase(id)
    }

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

}