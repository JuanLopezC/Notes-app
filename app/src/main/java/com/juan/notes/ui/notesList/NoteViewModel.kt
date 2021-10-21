package com.juan.notes.ui.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.notes.data.models.Note
import com.juan.notes.domain.usecase.notes.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    getNotesUseCase: GetNotesUseCase,
) : ViewModel() {

    private val notes = getNotesUseCase()
    val notesObserver: LiveData<MutableList<Note>> get() = notes


}