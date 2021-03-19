package com.example.weekthree.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekthree.R
import com.example.weekthree.data.NetworkResponse
import com.example.weekthree.data.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    private val notesAdapter: NoteAdapter by lazy {
        NoteAdapter()
    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    private val progressBar: ProgressBar by lazy { requireNotNull(view).findViewById<ProgressBar>(R.id.homeProgressBar) }


    // RecyclerView Reference:
    private lateinit var notesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.addNoteFloatingActionButton).setOnClickListener {
            findNavController().navigate(R.id.actionNoteFragmentToAddNewNoteFragment)
        }
        notesRecyclerView = view.findViewById<RecyclerView>(R.id.notesRecyclerViewLayout).apply {
            layoutManager = LinearLayoutManager(requireNotNull(context))
            adapter = notesAdapter
        }

       // observeViewModel()
        // viewModel.fetchNotes()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel()
        viewModel.fetchNotes()
    }


    private fun observeViewModel(){
        viewModel.notes.observe(viewLifecycleOwner, Observer { networkResponse ->
            when(networkResponse) {
                is NetworkResponse.Success -> {
                    hideLoading()
                    for (note in networkResponse.data) {
                        Log.d("Note", "${note.title}: ${note.description}")
                    }
                    notesAdapter.addItems(networkResponse.data)
                }
                is NetworkResponse.Error -> Toast.makeText(context, networkResponse.error.message, Toast.LENGTH_SHORT).show()
                is NetworkResponse.Loading -> {}
            }
        })
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}