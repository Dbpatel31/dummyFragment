package com.example.dummynote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NoteListFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private lateinit var recyclerView: RecyclerView

    private lateinit var addNoteButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_note_list, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerView)
        addNoteButton = view.findViewById(R.id.note_add_button)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = NoteListAdapter(viewModel.notes) { note ->
            viewModel.selectedNote.value = note
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NoteDetailFragment()).addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter

        addNoteButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AddNoteFragment()).addToBackStack(null).commit()
        }

        return view
    }



}