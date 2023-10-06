package com.bstudio.data.local_source.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bstudio.data.local_source.entity.NoteEntity


@Dao
interface NoteDao {
    @Insert
    suspend fun insertTask(note: NoteEntity): Long
    @Query("SELECT * FROM ${NoteEntity.NOTE_TABLE} ORDER BY ${NoteEntity.COLUMN_ID} desc")
    suspend fun fetchAllNotes(): List<NoteEntity>
    @Query("SELECT * FROM ${NoteEntity.NOTE_TABLE} WHERE ${NoteEntity.COLUMN_ID} =:taskId")
    suspend fun getTask(taskId: Int): NoteEntity
    @Update
    suspend fun updateTask(note: NoteEntity)
    @Delete
    suspend fun deleteTask(note: NoteEntity)
}