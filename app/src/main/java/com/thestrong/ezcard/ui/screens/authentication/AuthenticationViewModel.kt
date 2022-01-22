package com.thestrong.ezcard.ui.screens.authentication

import androidx.lifecycle.*
import com.thestrong.ezcard.data.model.User
import com.thestrong.ezcard.data.repository.login.LoginUser
import com.thestrong.ezcard.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.compose.viewModel

class AuthenticationViewModel(private val loginUser: LoginUser) : ViewModel() {
    private val errorOnFailure = "دوباره امتحان کنید"
    private val welcome = "خوش آمدید"
    private val successSignUp = "پسورد با موفقیت ثبت شد"
    private val errorLogin = "رمز عبور اشتباه است"
    private val successUpdatePassword = "رمز عبور با موفیت تغییر یافت!!"

    private val _operationsCheckUserIs = MutableLiveData<Resource<Boolean>>()
    val operationsCheckUserIs: LiveData<Resource<Boolean>> = _operationsCheckUserIs

    private val _operationsSignUp = MutableLiveData<Resource<String>>()
    val operationsSignUp: LiveData<Resource<String>> = _operationsSignUp

    private val _operationsLogin = MutableLiveData<Resource<String>>()
    val operationsLogin: LiveData<Resource<String>> = _operationsLogin

    init {
        checkUserIs()
    }

    fun signUp(user: User) {
        viewModelScope.launch {
            _operationsSignUp.value = Resource.Loading()
            val response = runCatching {
                loginUser.signIn(user)
            }
            response.onSuccess {
                _operationsSignUp.value = Resource.Success(welcome)
            }.onFailure {
                _operationsSignUp.value = Resource.Error(errorOnFailure)
            }

        }
    }

    fun loginUser(userPassword: String) {
        viewModelScope.launch {
            _operationsLogin.value = Resource.Loading()
            loginUser.login(userPassword).catch {
                _operationsLogin.value = Resource.Error(errorOnFailure)
            }.collect {
                if(it==null)
                {
                    _operationsLogin.value =Resource.Success(errorLogin)
                }
                else{
                    _operationsLogin.value = Resource.Success(welcome)
                }
            }
        }
    }

    fun updatePassword(user: User): LiveData<Resource<String>> = liveData {
        emit(Resource.Loading())
        val result = runCatching {
            loginUser.updateUser(user)
        }
        result.onSuccess {
            emit(Resource.Success(successUpdatePassword))
        }.onFailure {
            emit(Resource.Error(errorOnFailure))
        }
    }

    private fun checkUserIs() {
        viewModelScope.launch {
            _operationsCheckUserIs.value = Resource.Loading()
            loginUser.checkUserIs().catch { exception ->
                _operationsCheckUserIs.value = Resource.Error(exception.toString())
            }.collect {
                if (it.isNullOrEmpty()) {
                    _operationsCheckUserIs.value = Resource.Success(false)
                } else {
                   _operationsCheckUserIs.value = Resource.Success(true)
                }
            }
        }
    }
}