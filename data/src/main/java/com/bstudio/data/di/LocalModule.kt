package com.bstudio.data.di

import androidx.room.Room
import com.bstudio.data.local_source.database.AppDatabase
import com.bstudio.data.repository.NoteRepository
import com.bstudio.data.repository.NoteRepositoryImp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "app-db").build() }
    single { get<AppDatabase>().getNoteDao() }
    factory<NoteRepository> { NoteRepositoryImp(get()) }
}