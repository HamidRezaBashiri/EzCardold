package com.thestrong.ezcard.ui.screens.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.thestrong.ezcard.data.model.User
import com.thestrong.ezcard.ui.screens.signUp.SignUpViewModel
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
            .background(spBackgroundColor)
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
    val viewModel by viewModel<SignUpViewModel>()
    val signInBoxBackground: androidx.compose.ui.graphics.Color
    var textFiledState by remember {
        mutableStateOf("")
    }

    if (isSystemInDarkTheme()) {
        signInBoxBackground = LoginBoxBackgroundDark
    } else {
        signInBoxBackground = LoginBoxBackgroundLight
    }
    Column(modifier = Modifier.background(signInBoxBackground)) {
        Text(text = "سلام خوش آمدید")
        OutlinedTextField(
            value = textFiledState,
            label = { Text(text = "کلمه عبور خود را وارد کنید") },
            onValueChange = { textFiledState = it })
        Button(onClick = {
            val user = User(textFiledState, textFiledState)
            viewModel.signUp(user)
        }) {

        }
    }
}

@Composable
fun AnimatedLogo() {
//    TODO("Not yet implemented")
}
