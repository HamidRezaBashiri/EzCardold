package com.thestrong.ezcard.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thestrong.ezcard.ui.screens.cardList.CardListScreen
import com.thestrong.ezcard.ui.screens.home.HomeScreen
import com.thestrong.ezcard.ui.screens.settings.SettingScreen
import com.thestrong.ezcard.ui.common.BottomNavBar
import com.thestrong.ezcard.ui.common.MyTopBar
import com.thestrong.ezcard.ui.theme.EZCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EZCardTheme() {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = { MyTopBar() },
                        bottomBar = { BottomNavBar(navController = navController) }) {
                        EzCardNavHost(navController)
                    }

                }
            }
        }

    }


    //    setup navigation
    @Composable
    private fun EzCardNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
        NavHost(
            navController = navController,
//            check to see if user added password to protect app
            startDestination = if (true) "home" else "login",
            modifier = modifier
        ) {
            composable(route = "home") {
//                set navigation destination composable for home route
                HomeScreen()
            }
            composable(route = "wallet") {
                CardListScreen()
            }
            composable(route = "setting") {
                SettingScreen()
            }
            composable(route = "login") {

            }
            composable(route = "signup") {

            }
            composable(route = "addCard") {

            }
            composable(route = "shareCard") {

            }
        }

    }

}


