package com.example.dummynote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Note(
    val title: String,
    val content:String
)


class NoteViewModel:ViewModel() {

    val notes= mutableListOf<Note>()

    val selectedNote= MutableLiveData<Note>()

    fun addNote(note:Note){
        notes.add(note)
    }

}