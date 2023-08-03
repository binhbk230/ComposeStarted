package com.bstudio.composestarted.navigation

sealed class Destinations(val route: String) {
    object SecondScreen: Destinations("second_screen_route")
}