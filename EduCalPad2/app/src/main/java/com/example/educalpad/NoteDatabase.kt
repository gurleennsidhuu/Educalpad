package com.example.educalpad
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Note::class],version = 1,exportSchema = false)

//NoteDatabase is class to collect dao object

abstract class NoteDatabase: RoomDatabase() {
    // abstract function to which collects a Dao
    abstract fun getNoteDao(): NoteDao

    //this block is used to make a singleton object so that only one instance of Dao is made

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,NoteDatabase::class.java, "note_database").build()
                INSTANCE = instance
                instance
            }
        }
    }

}