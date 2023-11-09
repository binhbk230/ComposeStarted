package com.bstudio.composestarted.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bstudio.composestarted.navigation.Destinations
import com.bstudio.composestarted.ui.component.MyButton
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel : HomeScreenViewModel = koinViewModel()
    val uiData = viewModel.uiData

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        when (uiData) {
            is HomeScreenState.Error -> Text(text = uiData.error.message.orEmpty())
            HomeScreenState.Loading -> Text(text = "Loading")
            is HomeScreenState.SuccessData -> {
                OutlinedTextField(
                    value = uiData.name,
                    onValueChange = { viewModel.processUiEvent(HomeScreenEvent.InputData(it)) },
                    label = { Text("Name") }
                )
                MyButton(content = "Go to second screen", modifier = Modifier.align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                    navController.navigate(Destinations.SecondScreen.route)
                }
            }
        }
    }
}