package com.thestrong.ezcard.data.repository.card

import com.thestrong.ezcard.data.model.CreditCard
import kotlinx.coroutines.flow.Flow

interface Card {

    suspend fun addCard(creditCard: CreditCard)

    fun getCards(): Flow<List<CreditCard>>

    suspend fun deleteCard(card: CreditCard)

    suspend fun updateCard(card: CreditCard)
}