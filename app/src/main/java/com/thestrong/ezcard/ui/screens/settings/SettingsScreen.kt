package com.thestrong.ezcard.ui.screens.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.thestrong.ezcard.R

@Composable
fun SettingScreen() {
    Text(text = stringResource(id = R.string.setting))

}

@Composable
fun FiledText(modifier: Modifier = Modifier) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = modifier) {

        OutlinedTextField(value = text, onValueChange = { text = it })

    }
}