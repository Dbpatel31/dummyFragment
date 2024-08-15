package com.example.dummynote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class AddNoteFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var noteTitleEditText:EditText
    private lateinit var noteContentEditText:EditText
    private lateinit var saveNoteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_note, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)
        noteTitleEditText =view.findViewById(R.id.noteTitleEditText)
        noteContentEditText  = view.findViewById(R.id.noteContentEditText)
        saveNoteButton = view.findViewById(R.id.noteSaveButton)

        saveNoteButton.setOnClickListener {

            val title= noteTitleEditText.text.toString()
            val content= noteContentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()){
                 viewModel.addNote(Note(title,content))
                parentFragmentManager.popBackStack()

            }
            else{
                Toast.makeText(requireContext(),"Please enter a title and content", Toast.LENGTH_SHORT).show()
            }
        }
      return view
    }


}