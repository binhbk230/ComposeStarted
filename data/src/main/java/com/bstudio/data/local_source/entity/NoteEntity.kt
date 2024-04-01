package com.bstudio.data.local_source.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NoteEntity.NOTE_TABLE)
class NoteEntity {

    companion object {
        const val NOTE_TABLE = "note"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    private var id: Int = 0

    @ColumnInfo(name = COLUMN_TITLE)
    private var title: String? = null

    @ColumnInfo(name = COLUMN_DESCRIPTION)
    private var description: String? = null
}