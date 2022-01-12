package com.thestrong.ezcard.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.thestrong.ezcard.data.model.CreditCard
import com.thestrong.ezcard.data.model.User
import kotlinx.coroutines.flow.Flow

interface CardDao {

    @Insert(onConflict = REPLACE)
    suspend fun addCard(creditCard: CreditCard)

    @Query("SELECT * FROM CreditCard")
    fun getCard(): Flow<List<CreditCard>>

    @Query("DELETE FROM CreditCard")
    suspend fun deleteAllCard()

    @Delete()
    suspend fun deleteCard(user: User)

    @Update()
    suspend fun updateCard(creditCard: CreditCard)

    @Insert(onConflict = REPLACE)
    suspend fun addUser(user: User)

    @Update()
    suspend fun updateUser(user: User)

    fun getUser(user: User): Flow<User>
}