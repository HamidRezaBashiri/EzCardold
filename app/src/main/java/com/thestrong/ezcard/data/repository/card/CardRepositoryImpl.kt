package com.thestrong.ezcard.data.repository.card

import com.thestrong.ezcard.data.db.Database
import com.thestrong.ezcard.data.model.CreditCard
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl(private val database: Database) : Card {
    override suspend fun addCard(creditCard: CreditCard) = database.cardDao().addCard(creditCard)

    override fun getCards(): Flow<List<CreditCard>> = database.cardDao().getCard()

    override suspend fun deleteCard(card: CreditCard) = database.cardDao().deleteCard(card)

    override suspend fun updateCard(card: CreditCard) = database.cardDao().updateCard(card)
}