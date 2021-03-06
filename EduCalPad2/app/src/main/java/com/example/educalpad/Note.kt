package com.example.educalpad

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Entity is analogous to table we use in database or sql
and we've defined what will be the different columns and primary key of the table*/
@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text") val text: String) {

    //    id is autogenerated and we don't need to pass the id again and again to when new entity is created'
    @PrimaryKey(autoGenerate = true) var id = 0
}