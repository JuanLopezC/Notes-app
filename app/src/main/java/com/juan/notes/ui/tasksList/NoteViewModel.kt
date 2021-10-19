package com.juan.notes.ui.tasksList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juan.notes.data.models.Note
import com.juan.notes.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase
) : ViewModel() {

    val tasks = MutableLiveData<List<Note>>()


    fun getTasks(){
        viewModelScope.launch {
            val result = getNotesUseCase()
            if(!result.isNullOrEmpty()){
                tasks.postValue(result)
            }
        }
    }
}