package com.example.educalpad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //method to open Calculator when Calculator button is clicked
    fun openCalculator(view: View) {
        val intent = Intent(this, Calculator::class.java)

        startActivity(intent)
    }
    //method to open Notepad when Notepad button is clicked
    fun openNotepad(view: View) {
        val intent = Intent(this, Notepad::class.java)
        startActivity(intent)
    }
    //method to open EduNews when News button is clicked
    fun openNews(view: View) {
        val intent = Intent(this, EduNews::class.java)
        startActivity(intent)
    }
    //method to open search when Search button is clicked
    fun openSearch(view: View) {
        val intent = Intent(this, search::class.java)
        startActivity(intent)
   }

}