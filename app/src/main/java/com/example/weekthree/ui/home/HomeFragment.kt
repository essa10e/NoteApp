package com.example.weekthree.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weekthree.R
import com.example.weekthree.data.NetworkResponse
import com.example.weekthree.data.Note
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    private val progressBar: ProgressBar by lazy { requireNotNull(view).findViewById<ProgressBar>(R.id.homeProgressBar) }


    // RecyclerView Reference:
    private lateinit var todoRecyclerView: RecyclerView
    // ViewModel Instance:
    //private lateinit var todoViewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.fetchNotes()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        todoRecyclerView = view.findViewById(R.id.todoRecyclerViewLayout)
        //todoViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observeViewModel()
        viewModel.fetchNotes()

//        viewModel.notes.observe(this, Observer {
//
//            // create an instance of the adapter
//            val adapter = TodoAdapter(requireContext(), it)
//
//            todoRecyclerView.adapter = adapter
//        })

         //create an instance of the adapter
            val adapter = TodoAdapter(requireContext(), )
            todoRecyclerView.adapter = adapter
        return view
    }

    private fun observeViewModel(){
        viewModel.notes.observe(viewLifecycleOwner, Observer { networkResponse ->
            when(networkResponse) {
                is NetworkResponse.Success -> {
                    hideLoading()
                    for (note in networkResponse.data) {
                        Log.d("Note", "${note.title}: ${note.description}")
                    }
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