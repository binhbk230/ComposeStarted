package com.bstudio.composestarted.di

import com.bstudio.composestarted.ui.screen.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenViewModel() }
}