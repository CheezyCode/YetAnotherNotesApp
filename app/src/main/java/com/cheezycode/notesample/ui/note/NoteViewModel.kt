package com.cheezycode.notesample.ui.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.notesample.models.NoteRequest
import com.cheezycode.notesample.repository.NoteRepository
import kotlinx.coroutines.launch


class NoteViewModel (private val noteRepository: NoteRepository) : ViewModel() {

    val notesLiveData get() = noteRepository.notesLiveData
    val statusLiveData get() = noteRepository.statusLiveData

    fun createNote(noteRequest: NoteRequest) {
        viewModelScope.launch {
            noteRepository.createNote(noteRequest)
        }
    }

    fun getAllNotes() {
        viewModelScope.launch {
            noteRepository.getNotes()
        }
    }

    fun updateNote(id: String, noteRequest: NoteRequest){
        viewModelScope.launch {
            noteRepository.updateNote(id, noteRequest)
        }
    }

    fun deleteNote(noteId: String) {
        viewModelScope.launch {
            noteRepository.deleteNote(noteId)
        }
    }




}