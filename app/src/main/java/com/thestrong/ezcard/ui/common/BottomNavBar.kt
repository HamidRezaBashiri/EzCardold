package com.thestrong.ezcard.ui.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.thestrong.ezcard.ui.navigation.Screen

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(Screen.Wallet, Screen.Home, Screen.Settings)
    BottomNavigation(modifier = Modifier.clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {

//        getting current route to set current selected tab
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

//     mapping list items (screens) to BottomNavigationItem
        items.map {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title
                    )
                },

                selected = currentRoute == it.route,
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = Color.White.copy(alpha = 0.3f),
                onClick = {
                    navController.navigate(it.route){
                        restoreState  =true
                        launchSingleTop = true
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                    }

                }
            )
        }
    }
}