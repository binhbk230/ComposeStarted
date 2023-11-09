package com.bstudio.composestarted.ui.screen

import androidx.lifecycle.viewModelScope
import com.bstudio.composestarted.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class HomeScreenViewModel: BaseViewModel<HomeScreenState, HomeScreenEvent>(HomeScreenState.Idle) {

    override fun processUiEvent(event: HomeScreenEvent) {
        viewModelScope.launch {
            when(event) {
                is HomeScreenEvent.LoadData -> {
                    updateState(HomeScreenState.Loading)
                    delay(3000)
                    updateState(HomeScreenState.SuccessData(""))
                }
                is HomeScreenEvent.InputData -> {
                    updateState(HomeScreenState.SuccessData(event.inputData))
                }
                else -> {
                    updateState(HomeScreenState.Error(Throwable("Error happen")))
                }
            }
        }
    }


}

internal sealed class HomeScreenState {
    object Idle: HomeScreenState()
    class SuccessData(val name: String): HomeScreenState()
    class Error(val error: Throwable): HomeScreenState()
    object Loading: HomeScreenState()
}

internal sealed class HomeScreenEvent() {
    object LoadData: HomeScreenEvent()
    class InputData(val inputData: String) : HomeScreenEvent()
    object GotoNextScreen: HomeScreenEvent()
}
