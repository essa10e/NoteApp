package com.example.weekthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.example.weekthree.data.Note
import com.example.weekthree.ui.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var noteRepo: NotesRepositoryContractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            //noteRepo.addNote()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.mainFrameLayout, HomeFragment.newInstance())
                .commit()
        }

//        GlobalScope.launch {
//            val addNewNote = Note(title ="Tuesday", description = "Whatever")
//            noteRepo.addNote(addNewNote)
//            val notes: List<Note> = noteRepo.getNotes()
//            Log.d("MainActivity", "notes size:" + notes.size)
//        }

//        BuildConfig.API_KEY
//
//        if (BuildConfig.DEBUG) {
//
//        }
    }
}