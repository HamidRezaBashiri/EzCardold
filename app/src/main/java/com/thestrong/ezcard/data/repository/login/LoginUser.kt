package com.thestrong.ezcard.data.repository.login

import com.thestrong.ezcard.data.model.User
import kotlinx.coroutines.flow.Flow

interface LoginUser {

    suspend fun signIn(user: User)

    suspend fun updateUser(user: User)

    fun login(password: String): Flow<User>

    fun checkUserIs(): Flow<List<User>>

}