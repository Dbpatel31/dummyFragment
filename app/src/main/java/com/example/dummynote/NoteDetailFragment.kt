package com.example.dummynote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class NoteDetailFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var noteTitleTextView: TextView
    private lateinit var noteContentTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_note_detail, container, false)

        viewModel= ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)
        noteTitleTextView= view.findViewById(R.id.noteTitleTextView)
        noteContentTextView= view.findViewById(R.id.noteContentTextView)

       viewModel.selectedNote.observe(viewLifecycleOwner, Observer {
           note->
           note?.let {
               noteTitleTextView.text=it.title
               noteContentTextView.text=it.content
           }

      })
        return view
    }


}