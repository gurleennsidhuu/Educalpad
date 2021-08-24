package com.example.educalpad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educalpad.search
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_notepad.*

class Notepad : AppCompatActivity(), INoteRVAdapter {
    lateinit var viewModel: NoteViewModel

    //when activity is destroyed all the data it had get lost so after recreation it needs to recover data which task is accomplished by this function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notepad)

        //making adapter which is a bridge between UI component and data source that helps us to fill data in UI component
        //it holds the data and send the data to AdapterView then view can take the data from the adapter view

        recyclerView1.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this,this)
        recyclerView1.adapter = adapter

        //viewModel is initialized and its owner is MainActivity i.e. viewModel is attached with MainActivity
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel :: class.java)
        //here MainActivity is set as observer to the viewModel i.e. it observes all changes in viewModel and brings live data changes into action
        viewModel.allNotes.observe(this, Observer {list ->
            list?.let{
                adapter.updateList(it)
            }

        })
    }



    //when delete button is clicked this function is automatically called by the activity
    //implements the function which handles the click
    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted", Toast.LENGTH_LONG).show()
    }

    //function to handle click on submit data button
    fun submitData(view: View) {
        val noteText = input.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNote(Note(noteText))
            Toast.makeText(this,"$noteText Inserted", Toast.LENGTH_LONG).show()
        }
    }
    fun openCalculator(view: View) {
        val intent = Intent(this, Calculator::class.java)

        startActivity(intent)
    }

    fun openMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun openNews(view: View) {
        val intent = Intent(this, EduNews::class.java)
        startActivity(intent)
    }

    fun openSearch(view: View) {
        val intent = Intent(this, search::class.java)
        startActivity(intent)
    }
}