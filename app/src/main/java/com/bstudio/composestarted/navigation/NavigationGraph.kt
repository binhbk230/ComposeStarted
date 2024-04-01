package com.bstudio.composestarted.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bstudio.composestarted.AddPostScreen
import com.bstudio.composestarted.NotificationScreen
import com.bstudio.composestarted.SecondScreen
import com.bstudio.composestarted.ui.screen.HomeScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomNavItem.Home.screen_route) {

        addHomeGraph(navHostController)

        composable(BottomNavItem.AddPost.screen_route) {
            AddPostScreen()
        }
        composable(BottomNavItem.Settings.screen_route) {
            NotificationScreen()
        }



    }
}

fun NavGraphBuilder.addHomeGraph(navHostController: NavHostController) {
    navigation(route = BottomNavItem.Home.screen_route, startDestination = Destinations.HomeScreen.route) {
        composable(Destinations.HomeScreen.route) {
            HomeScreen(navHostController)
        }
        composable(Destinations.SecondScreen.route) {
            SecondScreen()
        }
    }

}