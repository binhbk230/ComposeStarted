package com.bstudio.composestarted.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState, UiEvent>(initUIState: UiState) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(initUIState)

    val uiState = _uiState.asStateFlow()

    abstract fun processUiEvent(event: UiEvent)

    protected fun updateNewState(state: UiState) {
        viewModelScope.launch {
            _uiState.emit(state)
        }
    }

}