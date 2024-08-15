package com.example.dummynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(private val notes: List<Note>,
    private  val onClick: (Note)->Unit):RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> (){

        class NoteViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
            var titleTextView= itemview.findViewById<TextView>(android.R.id.text1)



        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
       return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note= notes[position]
        holder.titleTextView.text=note.title
        holder.itemView.setOnClickListener {
            onClick(note)
        }
    }

}