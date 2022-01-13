package com.thestrong.ezcard.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thestrong.ezcard.ui.theme.LoginBoxBackgroundDark
import com.thestrong.ezcard.ui.theme.LoginBoxBackgroundLight
import com.thestrong.ezcard.ui.theme.SplashBackgroundDark
import com.thestrong.ezcard.ui.theme.SplashBackgroundLight
import org.koin.androidx.compose.viewModel


@Composable
fun SignInScreen(isFirstTimeLunch: Boolean = true) {
    val spBackgroundColor: androidx.compose.ui.graphics.Color = if (isSystemInDarkTheme()) {
        SplashBackgroundDark
    } else {
        SplashBackgroundLight
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(spBackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedLogo()
        if (isFirstTimeLunch) {
            LoginBox()
        } else LoginBox()
    }

}

@Composable
fun SignupBox() {
//    TODO("Not yet implemented")
}

@Composable
fun LoginBox() {
    val viewModel by viewModel<RegisterViewModel>()
    val signInBoxBackground: androidx.compose.ui.graphics.Color
    var textFiledState by rememberSaveable {
        mutableStateOf("")
    }

    if (isSystemInDarkTheme()) {
        signInBoxBackground = LoginBoxBackgroundDark
    } else {
        signInBoxBackground = LoginBoxBackgroundLight
    }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "سلام خوش آمدید")
        OutlinedTextField(
            value = textFiledState,
            label = { Text(text = "کلمه عبور خود را وارد کنید") },
            onValueChange = { textFiledState = it })
        Button(onClick = {
//            viewModel.signUp()
        }, modifier = Modifier.padding(8.dp),
            content = { Text(text = "test") })
    }
}

@Composable
fun AnimatedLogo() {
//    TODO("Not yet implemented")
}
