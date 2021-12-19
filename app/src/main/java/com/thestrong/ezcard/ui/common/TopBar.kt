package com.thestrong.ezcard.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyTopBar() {
    TopAppBar() {
        DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {

        }
    }
}
