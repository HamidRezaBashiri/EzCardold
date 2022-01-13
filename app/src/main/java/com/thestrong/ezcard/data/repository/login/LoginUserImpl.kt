package com.thestrong.ezcard.data.repository.login

import com.thestrong.ezcard.data.db.Database
import com.thestrong.ezcard.data.model.User
import kotlinx.coroutines.flow.Flow

class LoginUserImpl(private val database: Database) : LoginUser {
    override suspend fun addUser(user: User) = database.cardDao().addUser(user)

    override suspend fun updateUser(user: User) = database.cardDao().updateUser(user)

    override fun getUser(password: String): Flow<User> = database.cardDao().getUser(password)
}