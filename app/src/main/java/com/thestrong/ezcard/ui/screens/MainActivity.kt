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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thestrong.ezcard.ui.screens.home.HomeScreen
import com.thestrong.ezcard.ui.screens.settings.SettingScreen
import com.thestrong.ezcard.ui.common.BottomNavBar
import com.thestrong.ezcard.ui.common.MyTopBar
import com.thestrong.ezcard.ui.screens.authentication.AuthenticationScreen
import com.thestrong.ezcard.ui.screens.authentication.AuthenticationViewModel
import com.thestrong.ezcard.ui.theme.EZCardTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            EZCardTheme() {
                val navController = rememberNavController()
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
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

    }


    //    setup navigation
    @Composable
    private fun EzCardNavHost(
        navController: NavHostController, modifier: Modifier = Modifier
    ) {
        val viewModel: AuthenticationViewModel = getViewModel()
        val isLogin by viewModel.operationsCheckUserIs.observeAsState()
        isLogin?.let {login->

            NavHost(
                navController = navController,
//            check to see if user added password to protect app
                startDestination = if (false) "home" else "login",
                modifier = modifier
            ) {
                composable(route = "home") {
//                set navigation destination composable for home route
                    HomeScreen()
                }
                composable(route = "wallet") {
//                CardListScreen()
                    AuthenticationScreen(login.data)
                }
                composable(route = "setting") {
                    SettingScreen()
                }
                composable(route = "login") {
                    AuthenticationScreen(login.data)
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
}


