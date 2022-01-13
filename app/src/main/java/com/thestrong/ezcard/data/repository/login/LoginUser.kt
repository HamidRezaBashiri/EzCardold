package com.thestrong.ezcard.data.repository.login

import com.thestrong.ezcard.data.model.User
import kotlinx.coroutines.flow.Flow

interface LoginUser {

    suspend fun addUser(user: User)

    suspend fun updateUser(user: User)

    fun getUser(password: String): Flow<User>

}