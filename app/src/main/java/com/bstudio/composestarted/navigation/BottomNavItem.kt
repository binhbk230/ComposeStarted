package com.bstudio.composestarted.navigation
import com.bstudio.composestarted.R;

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object AddPost: BottomNavItem("Post",R.drawable.ic_add,"add_post")
    object Settings: BottomNavItem("Settings",R.drawable.ic_notification,"setting")
}