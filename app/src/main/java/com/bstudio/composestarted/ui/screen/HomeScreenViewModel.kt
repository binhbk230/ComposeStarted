package com.bstudio.composestarted.ui.screen

import androidx.lifecycle.viewModelScope
import com.bstudio.composestarted.base.BaseUIState
import com.bstudio.composestarted.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeScreenViewModel: BaseViewModel<BaseUIState<ArrayList<String>>, HomeScreenEvent>(BaseUIState.Loading) {

    override fun processUiEvent(event: HomeScreenEvent) {
        viewModelScope.launch {
            when(event) {
                is HomeScreenEvent.LoadData -> {
                    updateNewState(BaseUIState.Loading)
                    delay(3000)
                    updateNewState(BaseUIState.Success(arrayListOf()))
                }
                else -> {
                    updateNewState(BaseUIState.Error("Error "))
                }
            }
        }
    }


}

sealed class HomeScreenEvent() {
    object LoadData: HomeScreenEvent()
    object GotoNextScreen: HomeScreenEvent()
}
