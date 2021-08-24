package com.example.educalpad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// NewsListAdapter is a bridge between UI component and data source that helps us to fill data in UI component.
//it is a recycler view adapter
//implements listener when News item is clicked
class NewsListAdapter( private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>(){

    //ArrayList of News
    private val  items: ArrayList<News> = ArrayList()

    //create ViewHolder is a method in recyclerview.adapter
    //when a view is created (when the screen is scrolled down) by recyclerview it is called and inflates the layout to make a new itemView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        //that view is saved in viewHolder
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        //and it returns the viewHolder to the adapter
        return viewHolder
    }

    //this method binds all the views i.e. title author and image as our single view is comprised of these three
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        //Glide library is used to handle images
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    //it counts the items
    override fun getItemCount(): Int {
        return items.size
    }

    //as we the news are updated in seconds so this method takes care of that
    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

}

//News ViewHolder is a viewHolder for our news and contains three items
class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.title)
    val image: ImageView = itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.author)
}

//interface to call onItemClicked Method and passing news to it when item is clicked
interface NewsItemClicked {
    fun onItemClicked(item: News)
}