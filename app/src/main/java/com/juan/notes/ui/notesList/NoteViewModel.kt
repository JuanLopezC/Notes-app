package com.juan.notes.ui.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.notes.data.models.Note
import com.juan.notes.domain.usecase.GetNoteByIdUseCase
import com.juan.notes.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
) : ViewModel() {

//    val notes = getNotesUseCase()
//
//    fun getTasks(): LiveData<MutableList<Note>>{
//       return notes
//    }

    fun getNotesList(): LiveData<MutableList<Note>>{
        return getNotesUseCase()
    }

}