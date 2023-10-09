package com.bstudio.composestarted.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState, UiEvent>(initUIState: UiState) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(initUIState)
    protected val _uiData = _uiState.value

    private val uiState = _uiState.asStateFlow()
    val uiData : UiState
        @Composable
        get() {return uiState.collectAsState().value}


    abstract fun processUiEvent(event: UiEvent)

    protected fun updateState(state: UiState) {
        viewModelScope.launch {
            _uiState.emit(state)
        }
    }


}