package com.thestrong.ezcard.ui.screens.authentication

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thestrong.ezcard.R
import com.thestrong.ezcard.data.model.User
import com.thestrong.ezcard.ui.theme.*
import com.thestrong.ezcard.utils.Resource
import org.koin.androidx.compose.getViewModel


@Composable
fun AuthenticationScreen(
    isFirstTimeLunch: Boolean?,
    viewModel: AuthenticationViewModel = getViewModel()
) {
    val data by viewModel.operationsCheckUserIs.observeAsState()

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
        if (isFirstTimeLunch == true) {
            LoginBox(viewModel)
        } else {
            Register(viewModel)
        }
    }
}


@Composable
fun LoginBox(viewModel: AuthenticationViewModel) {
    val signInBoxBackground: androidx.compose.ui.graphics.Color
    val context = LocalContext.current
    var textFiledState by rememberSaveable {
        mutableStateOf("")
    }
    var progressBar by rememberSaveable {
        mutableStateOf(false)
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    viewModel.loginUser(textFiledState)
    val login by viewModel.operationsLogin.observeAsState()

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
                focusedBorderColor = Purple500,
                unfocusedBorderColor = MaterialTheme.colors.onSurface,
                placeholderColor = MaterialTheme.colors.onSurface,
                textColor = MaterialTheme.colors.onSurface,
                errorTrailingIconColor = MaterialTheme.colors.error,
                focusedLabelColor = Purple500,
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
        Button(onClick = {
            when (login) {
                is Resource.Loading -> {
                    progressBar = true
                }
                is Resource.Success -> {
                    progressBar = false

                        Toast.makeText(
                            context,
                            (login as Resource.Success<User>).data.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                }
                is Resource.Error -> {
                    progressBar = false
                    Toast.makeText(
                        context,
                        (login as Resource.Error<String>).message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }, modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp)),
            content = { Text(text = "ورود") })
    }
    if (progressBar) {
        ShowProgressBar()
    }
}

@Composable
fun Register(viewModel: AuthenticationViewModel) {
    val signInBoxBackground: androidx.compose.ui.graphics.Color
    val signUp by viewModel.operationsSignUp.observeAsState()
    var textFiledState by rememberSaveable {
        mutableStateOf("")
    }
    var textFiledStateRepeat by rememberSaveable {
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
                focusedBorderColor = Purple500,
                unfocusedBorderColor = MaterialTheme.colors.onSurface,
                placeholderColor = MaterialTheme.colors.onSurface,
                textColor = MaterialTheme.colors.onSurface,
                errorTrailingIconColor = MaterialTheme.colors.error,
                focusedLabelColor = Purple500,
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
        OutlinedTextField(
            value = textFiledStateRepeat,
            label = { Text(text = "کلمه عبور خود را تکرار کنید") },
            onValueChange = { textFiledStateRepeat = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple500,
                unfocusedBorderColor = MaterialTheme.colors.onSurface,
                placeholderColor = MaterialTheme.colors.onSurface,
                textColor = MaterialTheme.colors.onSurface,
                errorTrailingIconColor = MaterialTheme.colors.error,
                focusedLabelColor = Purple500,
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
        Button(onClick = {
            val user = User(textFiledState, textFiledStateRepeat)
            viewModel.signUp(user)
            signUp?.let {
                when (it) {
                    is Resource.Loading -> {
//                        ShowProgressBar()
                    }
                    is Resource.Success -> {

                    }
                    is Resource.Error -> {

                    }
                }
            }
        }, modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp)),
            content = { Text(text = "ورود") })
    }

}

@Composable
fun AnimatedLogo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_light),
            modifier = Modifier.fillMaxSize(),
            contentDescription = "logo"
        )
    }
}

@Composable
fun ShowProgressBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator()
    }
}
