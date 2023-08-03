package com.bstudio.composestarted.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bstudio.composestarted.AddPostScreen
import com.bstudio.composestarted.NotificationScreen
import com.bstudio.composestarted.SecondScreen
import com.bstudio.composestarted.ui.screen.HomeScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen(navHostController)
        }
        composable(BottomNavItem.AddPost.screen_route) {
            AddPostScreen()
        }
        composable(BottomNavItem.Notification.screen_route) {
            NotificationScreen()
        }

        composable(Destinations.SecondScreen.route) {
            SecondScreen()
        }

    }
}