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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thestrong.ezcard.R
import com.thestrong.ezcard.data.model.User
import com.thestrong.ezcard.ui.theme.*
import com.thestrong.ezcard.utils.Resource
import com.thestrong.ezcard.utils.ShowProgressBar
import com.thestrong.ezcard.utils.showToast
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
    var isError by rememberSaveable { mutableStateOf(false) }

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
            label = {
                if (isError) {
                    Text(stringResource(id = R.string.emptyText))
                } else {
                    Text(stringResource(id = R.string.login_filed))
                }
            },
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
            isError = isError,
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
            isError = false
            if (textFiledState.isNotEmpty()) {
                when (login) {
                    is Resource.Loading -> {
                        progressBar = true
                    }
                    is Resource.Success -> {
                        progressBar = false
                        showToast(
                            context = context,
                            text = (login as Resource.Success<String>).data.toString()
                        )
                    }
                    is Resource.Error -> {
                        progressBar = false
                        showToast(
                            context = context,
                            text = (login as Resource.Error<String>).message.toString()
                        )
                    }
                }

            } else {
                isError = true
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
    var isErrorPassword by rememberSaveable { mutableStateOf(false) }
    var isNotEqualsTextField by rememberSaveable { mutableStateOf(false) }
    var isErrorPasswordRepeate by rememberSaveable { mutableStateOf(false) }

    var textFiledState by rememberSaveable {
        mutableStateOf("")
    }
    var textFiledStateRepeat by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    var progressBar by rememberSaveable {
        mutableStateOf(false)
    }

    val context = LocalContext.current

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
            label = {
                if (isErrorPassword) {
                    Text(stringResource(id = R.string.emptyText))
                } else if (isNotEqualsTextField) {
                    Text(stringResource(id = R.string.isNotEquals))
                } else {
                    Text(stringResource(id = R.string.login_filed))
                }
            },
            onValueChange = { textFiledState = it },
            isError = isErrorPassword || isNotEqualsTextField,
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
                    R.drawable.ic_visibility
                else R.drawable.ic_visibility_off


                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = ImageVector.vectorResource(id = image), "")
                }
            })
        OutlinedTextField(
            value = textFiledStateRepeat,
            label = {
                if (isErrorPasswordRepeate) {
                    Text(stringResource(id = R.string.emptyText))
                } else if (isNotEqualsTextField) {
                    Text(stringResource(id = R.string.isNotEquals))
                } else {
                    Text(stringResource(id = R.string.login_filed))
                }
            },
            onValueChange = { textFiledStateRepeat = it },
            isError = isErrorPasswordRepeate || isNotEqualsTextField,
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
                    ImageVector.vectorResource(id = R.drawable.ic_visibility)
                else ImageVector.vectorResource(id = R.drawable.ic_visibility_off)


                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = image, "")
                }
            })
        Button(onClick = {
            if (textFiledState.isNullOrEmpty()) {
                isErrorPassword = true
            } else if (textFiledStateRepeat.isNullOrEmpty()) {
                isErrorPassword = false
                isErrorPasswordRepeate = true
            } else if (textFiledState != textFiledStateRepeat || textFiledStateRepeat != textFiledState) {
                isErrorPassword = false
                isErrorPasswordRepeate = false
                isNotEqualsTextField = true
            } else {
                isErrorPassword = false
                isErrorPasswordRepeate = false
                isNotEqualsTextField = false
                val user = User(textFiledState, textFiledStateRepeat)
                viewModel.signUp(user)
                signUp?.let { signUp ->
                    when (signUp) {
                        is Resource.Loading -> {
                            progressBar = true
                        }
                        is Resource.Success -> {
                            progressBar = false
                            showToast(context, signUp.data.toString())
                        }
                        is Resource.Error -> {
                            progressBar = false
                            showToast(context, signUp.message.toString())
                        }
                    }
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


