package com.example.educalpad

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.educalpad.search
import kotlinx.android.synthetic.main.activity_edu_news.*
import kotlinx.android.synthetic.main.activity_main.*

//Main Activity for News Functionality
// Extends Interface NewsItemClicked so that it can have the methods NewsItemClicked has
class EduNews : AppCompatActivity(), NewsItemClicked {
    private lateinit var mAdapter: NewsListAdapter


    //This Method is called when the Activity is created and have layout activity_edu_news
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edu_news)

        //recycler view is a view make our app scrollable ..
        //here we've chose the linear layout i.e. we can scroll up and down
        recyclerView1.layoutManager = LinearLayoutManager(this)
        //calling fetchdata method
        fetchData()
        //adapter directly interacts with the recycler view and all the data passed to the adapter is passed to the recyclerview
        mAdapter = NewsListAdapter(this)
        recyclerView1.adapter = mAdapter

    }

    //fetchdata() fetches all the News Data i.e. title, author, url and image of the news
    private fun fetchData() {
        //url of NewsApi
        val url = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=5b3a3e92a71b4e9b99d843a6efe52773"
        //creating of a jsonobject which requests the data from the API
        val jsonObjectRequest = object: JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                {
                    //A jsonArray is made because we have lots of news articles and to save them we need an arraylist
                    val newsJsonArray = it.getJSONArray("articles")
                    val newsArray = ArrayList<News>()
                    //from starting to end we make a for loop to save every data in our arrayList
                    for (i in 0 until newsJsonArray.length()) {
                        val newsJsonObject = newsJsonArray.getJSONObject(i)
                        val news = News(
                                //we have four type of data in a news . title, author, url and urlToImage
                                newsJsonObject.getString("title"),
                                newsJsonObject.getString("author"),
                                newsJsonObject.getString("url"),
                                newsJsonObject.getString("urlToImage")
                        )
                        //and News is added after termination of for loop
                        newsArray.add(news)
                    }
                    //and adapter is also updated
                    mAdapter.updateNews(newsArray)
                },
                {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
        )

        {
            //added method to getHeaders when app shows code203 error
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }
        //we make a singleton instance for this function so that this app can get only one instance of this functionality at the time
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }


    //Methods to handle clicks
    //when an news is clicked it builds an intent and opens a new chrome custom tab
    //and the url is parsed of that item and opens in custom tab
    override fun onItemClicked(item: News) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url))
    }

    //method to open calculator when calculator button is clicked
    fun openCalculator(view: View) {
        val intent = Intent(this, Calculator::class.java)

        startActivity(intent)
    }

    //method to open Notepad button is clicked
    fun openNotepad(view: View) {
        val intent = Intent(this, Notepad::class.java)
        startActivity(intent)
    }

    //method to open MainActivity when Home button is clicked
    fun openMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    //method to open search activity when search button is clicked
    fun openSearch(view: View) {
        val intent = Intent(this, search::class.java)
        startActivity(intent)
    }
}