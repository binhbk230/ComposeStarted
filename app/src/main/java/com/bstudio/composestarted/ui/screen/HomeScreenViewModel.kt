package com.bstudio.composestarted.ui.screen

import androidx.lifecycle.viewModelScope
import com.bstudio.composestarted.base.BaseUIState
import com.bstudio.composestarted.base.BaseViewModel
import kotlinx.coroutines.launch

internal class HomeScreenViewModel: BaseViewModel<BaseUIState<HomeUIData>, HomeScreenEvent>(BaseUIState()) {

    override fun processUiEvent(event: HomeScreenEvent) {
        viewModelScope.launch {
            when(event) {
                is HomeScreenEvent.LoadData -> {
                    updateState(_uiData.copy(isLoading = true, data = null))
                }
                is HomeScreenEvent.InputData -> {
                    updateState(_uiData.copy(isLoading = false, data = HomeUIData(event.inputData)))
                }
                else -> {
                    updateState(_uiData.copy(error = Throwable("Error")))
                }
            }
        }
    }


}

internal data class HomeUIData(val name: String)

sealed class HomeScreenEvent() {
    object LoadData: HomeScreenEvent()
    class InputData(val inputData: String) : HomeScreenEvent()
    object GotoNextScreen: HomeScreenEvent()
}
