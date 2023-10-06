package com.bstudio.data.repository

import com.bstudio.data.local_source.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNote(): Flow<List<NoteEntity>>
}