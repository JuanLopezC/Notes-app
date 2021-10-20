package com.juan.notes.ui.notesDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.notes.data.models.Note
import com.juan.notes.domain.usecase.GetNoteByIdUseCase
import com.juan.notes.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase
): ViewModel() {


    fun insertNote(note: Note){
        viewModelScope.launch {
            insertNoteUseCase(note)
        }
    }

    fun getNote(id: Long): LiveData<Note> {
        return getNoteByIdUseCase(id)
    }
}