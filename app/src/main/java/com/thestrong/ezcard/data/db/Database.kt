package com.thestrong.ezcard.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thestrong.ezcard.data.model.CreditCard
import com.thestrong.ezcard.data.model.User

@Database(entities = [CreditCard::class,User::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun cardDao(): CardDao
}