package com.example.educalpad

import androidx.lifecycle.LiveData

// Repository is a single source of truth for all app data. clean API for UI to communicate with

class NoteRepository (private val noteDao: NoteDao){
    // getAllnotes function brings data from Dao and it is saved in allNotes variable
    val allNotes: LiveData<List<Note>> = noteDao.getAllnotes()


    //function is used to insert data sent by the noteDao object
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    //function is used to delete data sent by the noteDao object
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}