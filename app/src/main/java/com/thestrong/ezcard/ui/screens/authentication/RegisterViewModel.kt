package com.thestrong.ezcard.ui.screens.authentication

import androidx.lifecycle.*
import com.thestrong.ezcard.data.model.User
import com.thestrong.ezcard.data.repository.login.LoginUser
import kotlinx.coroutines.launch

class AuthenticationViewModel(private val loginUser: LoginUser) : ViewModel() {
    private val errorOnFailure = "دوباره امتحان کنید"
    private val welcome = "خوش آمدید"

    private var _signUp = MutableLiveData<String>()
    val signUpLiveData: LiveData<String> = _signUp

    private var _login = MutableLiveData<String>()
    val loginLiveData: LiveData<String> = _login

    fun signUp(user: User) {
        viewModelScope.launch {
            val response = runCatching {
                loginUser.signIn(user)
            }
            response.onSuccess {
                _signUp.value = "پسورد با موفقیت ثبت شد"
            }.onFailure {
                _signUp.value = errorOnFailure
            }
        }
    }

    fun checkUser(userPassword: String) {
        viewModelScope.launch {
            val login = runCatching {
                loginUser.login(userPassword).asLiveData()
            }
            login.onSuccess {
                it.value?.let { result ->
                    if (result) {
                        _login.value = welcome
                    } else {
                        _login.value = "دوباره امتحان کنید"
                    }
                }

            }.onFailure {
                _login.value = errorOnFailure
            }
        }

    }

    fun updatePassword(user: User): LiveData<String> = liveData {
        val result = kotlin.runCatching {
            loginUser.updateUser(user)
        }
        result.onSuccess {
            emit("رمز عبور با موفیت تغییر یافت!!")
        }.onFailure {
            emit(errorOnFailure)
        }
    }

}