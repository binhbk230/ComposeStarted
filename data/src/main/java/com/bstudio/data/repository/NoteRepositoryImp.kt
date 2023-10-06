package com.bstudio.data.repository

import com.bstudio.data.local_source.dao.NoteDao
import com.bstudio.data.local_source.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepositoryImp(private val noteDao: NoteDao): NoteRepository {
    override fun getAllNote(): Flow<List<NoteEntity>> {
        return flow {
            emit(noteDao.fetchAllNotes())
        }
    }
}