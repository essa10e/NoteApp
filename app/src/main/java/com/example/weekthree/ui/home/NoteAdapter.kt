package com.example.weekthree.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekthree.R
import com.example.weekthree.data.Note

class NoteAdapter():
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val items = mutableListOf<Note>()

    fun addItems(items: List<Note>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noteItem = items[position]

        holder.titleTextView.setText(noteItem.title)
        holder.descriptionTextView.setText(noteItem.description)
    }

    override fun getItemCount() = items.size
}