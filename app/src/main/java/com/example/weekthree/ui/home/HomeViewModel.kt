package com.example.weekthree.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weekthree.NotesRepositoryContractor
import com.example.weekthree.data.NetworkResponse
import com.example.weekthree.data.Note
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val noteRepo: NotesRepositoryContractor
) : ViewModel(){

    // MutableLiveData: it's an object that has a reference to the lifecycle. It's aware of the lifecycle
    val notes = MutableLiveData<NetworkResponse<List<Note>>>()

    fun fetchNotes(){
        notes.postValue(NetworkResponse.Loading())
        viewModelScope.launch {
            try {
                notes.postValue(NetworkResponse.Success(noteRepo.getNotes()))
            } catch (e: Throwable) {
                notes.postValue(NetworkResponse.Error(e))
            }
        }
    }
}