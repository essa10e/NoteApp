package com.example.weekthree.di.module

import android.content.Context
import androidx.room.Room
import com.example.weekthree.NoteRepository
import com.example.weekthree.NotesRepositoryContractor
import com.example.weekthree.db.AppDatabase
import com.example.weekthree.db.NoteDao
import com.example.weekthree.di.AppComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    private val DB_NAME = "Tuesday_DB"

    @Singleton
    @Provides
    fun provideRoomDb(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: AppDatabase): NoteDao = appDatabase.notesDao()

    @Singleton
    @Provides
    fun provideNoteRepo(noteDao: NoteDao): NotesRepositoryContractor = NoteRepository(noteDao)
}