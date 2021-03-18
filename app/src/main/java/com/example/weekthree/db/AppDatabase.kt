package com.example.weekthree.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weekthree.data.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun notesDao(): NoteDao
}