package com.bstudio.composestarted.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MyBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.AddPost,
        BottomNavItem.Notification,
    )

    NavigationBar(containerColor = Color.Cyan, contentColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            item ->
            NavigationBarItem(icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.title) }, label = { Text(
                text = item.title
            )}, onClick = {
                navController.navigate(item.screen_route) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(item.screen_route)
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            selected = currentRoute == item.screen_route || (currentRoute == Destinations.HomeScreen.route && item.screen_route == BottomNavItem.Home.screen_route)
                )
        }
    }

}