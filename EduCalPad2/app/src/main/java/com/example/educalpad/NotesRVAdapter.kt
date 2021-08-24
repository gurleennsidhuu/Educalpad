package com.example.educalpad
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: INoteRVAdapter) : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Note>()

    //it takes itemView i.e. an text and a delete button as shown in item_note.xml file

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //textView collects text we inserted
        val textView: TextView = itemView.findViewById<TextView>(R.id.text)
        // delete button is a button which deletes the (entity)text from the database
        val deleteButton: ImageView = itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    //create items here we've items as entities(text and a delete button)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        //passing view into viewHolder variable by inflating the layout
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent, false))
        //handle click on deleteButton
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }

        //returning viewHolder to Activity
        return viewHolder
    }

    // this function binds all the items
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = allNotes[position]
        //set holder textView text as current note text
        holder.textView.text = currentNote.text

    }

    //it updates list when new entities are inserted or deleted
    fun updateList(newList: List<Note>){
        //it clears the previous list
        allNotes.clear()
        // adds new list in allNotes
        allNotes.addAll(newList)

        //These changes are updated
        notifyDataSetChanged()
    }

    //it has information about the number of list items
    override fun getItemCount(): Int {
        return allNotes.size

    }
}

//Interface to handle clicks
interface INoteRVAdapter{
    fun onItemClicked(note: Note)
}