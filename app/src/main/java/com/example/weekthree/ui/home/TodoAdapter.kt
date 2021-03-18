package com.example.weekthree.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekthree.R
import com.example.weekthree.data.Note

class TodoAdapter(val context: Context,
                  private val todoList: List<Note>):
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todoItem = todoList[position]
        holder.titleTextView.setText(todoItem.title)
        holder.descriptionTextView.setText(todoItem.description)
    }

    override fun getItemCount() = todoList.size
}