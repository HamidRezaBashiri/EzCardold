package com.thestrong.ezcard.ui.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thestrong.ezcard.R
import com.thestrong.ezcard.ui.theme.*
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

@Preview
@Composable
fun LoginBox() {
    val viewModel by viewModel<AuthenticationViewModel>()
    val signInBoxBackground: androidx.compose.ui.graphics.Color
    var textFiledState by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    if (isSystemInDarkTheme()) {
        signInBoxBackground = LoginBoxBackgroundDark
    } else {
        signInBoxBackground = LoginBoxBackgroundLight
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(15))
            .background(color = MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "سلام", fontSize = 20.sp, color = MaterialTheme.colors.onSurface)
            Text(text = "خوش آمدید", color = MaterialTheme.colors.onSurface)
        }

        OutlinedTextField(
            value = textFiledState,
            label = { Text(text = "کلمه عبور خود را وارد کنید") },
            onValueChange = { textFiledState = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple500 ,
                unfocusedBorderColor = MaterialTheme.colors.onSurface ,
                placeholderColor = MaterialTheme.colors.onSurface,
                textColor = MaterialTheme.colors.onSurface,
                errorTrailingIconColor =MaterialTheme.colors.error,
                focusedLabelColor = Purple500 ,
                unfocusedLabelColor = MaterialTheme.colors.onSurface,
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Menu
                else Icons.Filled.ShoppingCart

                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = image, "")
                }
            })
        Button(onClick = {}, modifier = Modifier.padding(16.dp),
            content = { Text(text = "ورود") })
    }

}


@Composable
fun AnimatedLogo() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo_light), contentDescription = "logo")
    }
}
