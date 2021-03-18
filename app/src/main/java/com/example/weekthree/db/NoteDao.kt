package com.example.weekthree.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.weekthree.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM Notes LIMIT :limit")
    suspend fun getNotes(limit: Int): List<Note>

    @Insert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)


}