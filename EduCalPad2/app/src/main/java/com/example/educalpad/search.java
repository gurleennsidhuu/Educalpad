package com.example.educalpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;

//Activity class for search functionality
public class search extends AppCompatActivity {

    //webView and SearchView is implemented
    private WebView webSearch;
    private SearchView searchBar;

    //Method on create is called when search functionality is used
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //linked layout file is activity_search
        setContentView(R.layout.activity_search);
        //passing the id of google to webView
        webSearch= (WebView) findViewById(R.id.google);
        //webClient is needed to make a view
        webSearch.setWebViewClient(new WebViewClient());
//         webSearch.setBackgroundResource(R.drawable.logo);
        webSearch.setBackgroundColor(Color.TRANSPARENT);

        searchBar = (SearchView) findViewById(R.id.searchBar);
        //setting a text listener
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

            //when a query is submitted by clicking the submit button the query is passed to google search
            @Override
            public boolean onQueryTextSubmit(String query) {
                webSearch.loadUrl("https://www.google.com/search?q="+searchBar.getQuery());
                return false;
            }
        });
    }



    //method to open calculator when calculator button is clicked
    public void openCalculator(View view){
        Intent intent = new Intent(this,Calculator.class);
        startActivity(intent);
    }
    //method to open Notepad button is clicked
    public void openNotepad(View view){
        Intent intent = new Intent(this,Notepad.class);
        startActivity(intent);
    }
    //method to open EduNews when News button is clicked
    public void openNews(View view){
        Intent intent = new Intent(this,EduNews.class);
        startActivity(intent);
    }
    //method to open MainActivity when Home button is clicked
    public void openMain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}