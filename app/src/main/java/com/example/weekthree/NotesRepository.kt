package com.example.weekthree

import com.example.weekthree.data.Note
import com.example.weekthree.db.NoteDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface NotesRepositoryContractor {
    suspend fun addNote(note: Note)
    suspend fun getNotes(): List<Note>
    suspend fun deleteNote(note: Note)
}

class NoteRepository (
    private val dao: NoteDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): NotesRepositoryContractor {

    private val LIMIT = 50

    override suspend fun addNote(note: Note) {
        withContext(dispatcher) {
            dao.insertNote(note)
        }
    }

    override suspend fun getNotes(): List<Note> {
        return withContext(dispatcher) {
            return@withContext dao.getNotes(LIMIT)
        }
    }

    override suspend fun deleteNote(note: Note) {
        withContext(dispatcher) {
            dao.deleteNote(note)
        }
    }

}