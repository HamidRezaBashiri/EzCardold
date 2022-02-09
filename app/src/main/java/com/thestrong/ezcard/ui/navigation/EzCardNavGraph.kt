package com.thestrong.ezcard.ui.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thestrong.ezcard.ui.screens.addCard.AddCardScreen
import com.thestrong.ezcard.ui.screens.addCard.AddCardViewModel
import com.thestrong.ezcard.ui.screens.authentication.AuthenticationScreen
import com.thestrong.ezcard.ui.screens.authentication.AuthenticationViewModel
import com.thestrong.ezcard.ui.screens.cardList.CardListScreen
import com.thestrong.ezcard.ui.screens.home.HomeScreen
import com.thestrong.ezcard.ui.screens.home.HomeViewModel
import com.thestrong.ezcard.ui.screens.settings.SettingScreen
import com.thestrong.ezcard.ui.screens.settings.SettingsViewModel
import com.thestrong.ezcard.ui.screens.shareCard.ShareCardScreen
import com.thestrong.ezcard.ui.screens.shareCard.ShareCardViewModel
import org.koin.androidx.compose.getViewModel

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val WALLET_ROUTE = "wallet"
    const val SETTINGS_ROUTE = "settings"
    const val AUTHENTICATION_ROUTE = "authentication"
    const val SHARE_CARD_ROUTE = "shareCard"
    const val ADD_CARD_ROUTE = "addCard"
}

@Composable
fun EzCardNavGraph(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestinations.AUTHENTICATION_ROUTE
) {
    val actions = remember(navController) { MainActions(navController) }

    //    setup navigation for main screen  (home)

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = "authentication") {
            val viewModel: AuthenticationViewModel = getViewModel()

            AuthenticationScreen(
                viewModel = viewModel,
                navigateToHome = actions.navigateToHome
            )
        }
        composable(route = "home") {
            val viewModel: HomeViewModel = getViewModel()
            HomeScreen(viewModel = viewModel)
        }
        composable(route = "wallet") {
            CardListScreen()
        }
        composable(route = "setting") {
            val viewModel: SettingsViewModel = getViewModel()
            SettingScreen(viewModel = viewModel)
        }

        composable(route = "addCard") {
            val viewModel: AddCardViewModel = getViewModel()
            AddCardScreen(viewModel = viewModel)

        }
        composable(route = "shareCard") {
            val viewModel: ShareCardViewModel = getViewModel()
            ShareCardScreen(viewModel = viewModel)
        }
    }

}

class MainActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.popBackStack()
        navController.navigate(MainDestinations.HOME_ROUTE)
    }
    val navigateToShareCard: () -> Unit = {
        navController.navigate(MainDestinations.SHARE_CARD_ROUTE)
    }
    val navigateToAddCard: () -> Unit = {
        navController.navigate(MainDestinations.ADD_CARD_ROUTE)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}