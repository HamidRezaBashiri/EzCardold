package com.thestrong.ezcard.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thestrong.ezcard.ui.common.BottomNavBar
import com.thestrong.ezcard.ui.common.MyTopBar
import com.thestrong.ezcard.ui.navigation.EzCardNavGraph
import com.thestrong.ezcard.ui.navigation.MainDestinations
import com.thestrong.ezcard.ui.theme.EZCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            EZCardTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Surface(color = MaterialTheme.colors.background) {
                        MainScreenContent(navController = navController)
                    }
                }
            }
        }

    }

    @Composable
    private fun MainScreenContent(navController: NavHostController) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.AUTHENTICATION_ROUTE

        Scaffold(
            topBar = {
                if (currentRoute == "authentication") {
                } else MyTopBar()
            },
            bottomBar = {
                if (currentRoute == "authentication") {
                } else BottomNavBar(navController = navController)
            }) {
            EzCardNavGraph(navController)
        }
    }

}





