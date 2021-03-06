package com.thestrong.ezcard.data.repository.login

import com.thestrong.ezcard.data.data_source.local.db.Database
import com.thestrong.ezcard.data.model.User
import kotlinx.coroutines.flow.Flow

class LoginUserImpl(private val database: Database) : LoginUser {
    override suspend fun signIn(user: User) = database.cardDao().signIn(user)

    override suspend fun updateUser(user: User) = database.cardDao().updateUser(user)

    override fun login(password: String): Flow<User> = database.cardDao().login(password)

    override fun checkUserIs(): Flow<List<User>> = database.cardDao().checkUserIs()
}