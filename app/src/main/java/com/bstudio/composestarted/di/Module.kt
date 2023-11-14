package com.bstudio.composestarted.di

import com.bstudio.composestarted.MainActivityViewModel
import com.bstudio.composestarted.ui.screen.HomeScreenViewModel
import com.bstudio.composestarted.util.SharePrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { MainActivityViewModel(get()) }
    single { SharePrefManager(androidContext()) }
}