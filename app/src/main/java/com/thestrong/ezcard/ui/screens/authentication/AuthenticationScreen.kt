package com.thestrong.ezcard.ui.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thestrong.ezcard.R
import com.thestrong.ezcard.ui.theme.LoginBoxBackgroundDark
import com.thestrong.ezcard.ui.theme.LoginBoxBackgroundLight
import com.thestrong.ezcard.ui.theme.SplashBackgroundDark
import com.thestrong.ezcard.ui.theme.SplashBackgroundLight
import org.koin.androidx.compose.viewModel


@Composable
fun AuthenticationScreen(isFirstTimeLunch: Boolean = true) {
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
    val viewModel by viewModel<AuthenticationViewModel>()
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
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "سلام")
        Text(text = "خوش آمدید")
    }

    OutlinedTextField(
        value = textFiledState,
        label = { Text(text = "کلمه عبور خود را وارد کنید") },
        onValueChange = { textFiledState = it })
    Button(onClick = {}, modifier = Modifier.padding(16.dp),
        content = { Text(text = "test") })
}


@Composable
fun AnimatedLogo() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo_light), contentDescription = "logo")
    }
}
