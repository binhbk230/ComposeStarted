package com.bstudio.composestarted.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bstudio.composestarted.R
import com.bstudio.composestarted.base.BaseUIState
import com.bstudio.composestarted.navigation.Destinations
import com.bstudio.composestarted.ui.component.MyButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel : HomeScreenViewModel = koinViewModel()
    val uiState = viewModel.uiState.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        MyButton(content = "Go to second screen", modifier = Modifier.align(Alignment.CenterHorizontally)) {
            navController.navigate(Destinations.SecondScreen.route)
           // viewModel.processUiEvent(HomeScreenEvent.LoadData)
        }
        when (uiState) {
            is BaseUIState.Loading -> Text(text = "Loading")
            else -> Text(text = "Success")
        }
    }
}