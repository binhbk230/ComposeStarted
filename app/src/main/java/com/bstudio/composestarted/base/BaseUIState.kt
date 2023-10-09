package com.bstudio.composestarted.base

data class BaseUIState<out T : Any>(
    val data: T? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null
)
