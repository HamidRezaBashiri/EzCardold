package com.thestrong.ezcard.ui.navigation

import androidx.annotation.DrawableRes
import com.thestrong.ezcard.R

sealed class Screen(val route: String, val title: String, @DrawableRes val icon: Int){
    object Wallet:Screen("wallet","CardList",R.drawable.ic_wallet)
    object Home :Screen("home","Home", R.drawable.ic_home)
    object Settings:Screen("setting","Setting",R.drawable.ic_setting)

}
