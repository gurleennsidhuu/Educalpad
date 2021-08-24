package com.example.educalpad
import androidx.lifecycle.LiveData
import androidx.room.*

//Dao is Data access object .. it is used to fetch data from the SQLite

@Dao
interface NoteDao {

    //    function to insert an entity
//    it is allowed to insert two same entities
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    // suspend is a coroutine which allows function to run in background so that it doesn't affect other activities
    // because IO operations are heavy operations and if they work on the main thread the app will be laggy
    suspend fun insert(note: Note)
    // function to delete an entity
    @Delete
    suspend fun delete(note: Note)

    //function to perform a query
    //this query orders the entities in ascending order based on their id
    @Query("Select * from notes_table order by id DESC")
    //live data can be observed i.e. when the list is updated observer directly finds the updation and nothing extra needs to be done
    fun getAllnotes(): LiveData<List<Note>>
}