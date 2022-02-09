package com.thestrong.ezcard.ui.screens.addCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun AddCardScreen(viewModel: AddCardViewModel) {

    var textFiledCardNumberState by rememberSaveable { mutableStateOf("") }
    var textFiledShabaState by rememberSaveable { mutableStateOf("") }
    var textFiledCardNameState by rememberSaveable { mutableStateOf("") }

    Column() {
        TextField(
            value = textFiledCardNumberState,
            onValueChange = { textFiledCardNumberState = it })
        TextField(value = "s", onValueChange = {})
        TextField(value = "s", onValueChange = {})
        Row() {
            TextField(value = "S", onValueChange = {})
            Spacer(modifier = Modifier.weight(1f))
            TextField(value = "S", onValueChange = {})
        }
        Button(onClick = { /*TODO*/ }) {

        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}