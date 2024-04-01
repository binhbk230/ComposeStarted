package com.bstudio.data.local_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bstudio.data.local_source.dao.NoteDao
import com.bstudio.data.local_source.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1 , exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
}