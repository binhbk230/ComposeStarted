package com.bstudio.composestarted.base

sealed class BaseUIState<out T : Any> {
    object Loading : BaseUIState<Nothing>()
    data class Success<out T : Any>(val data: T) : BaseUIState<T>()
    data class Error(val message: String) : BaseUIState<Nothing>()
}
