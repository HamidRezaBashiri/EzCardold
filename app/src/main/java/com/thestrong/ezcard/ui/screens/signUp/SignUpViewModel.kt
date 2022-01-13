package com.thestrong.ezcard.ui.screens.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thestrong.ezcard.data.model.User
import com.thestrong.ezcard.data.repository.login.LoginUser
import kotlinx.coroutines.launch

class SignUpViewModel(private val loginUser: LoginUser) : ViewModel() {
    private var _signUp = MutableLiveData<String>()
    val signUpLiveData: LiveData<String> = _signUp

    fun signUp(user: User) {
        viewModelScope.launch {
            val response = runCatching {
                loginUser.addUser(user)
            }
            response.onSuccess {
                _signUp.value = "پسورد با موفقیت ثبت شد"
            }.onFailure {
                _signUp.value = it.message.toString()
            }
        }
    }
}