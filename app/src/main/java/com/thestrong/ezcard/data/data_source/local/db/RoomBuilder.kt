package com.thestrong.ezcard.data.data_source.local.db

import android.content.Context
import androidx.room.Room
import com.thestrong.ezcard.utils.Constants.DATABASE_NAME

object RoomBuilder {
    private var instance: Database? = null
    fun getInstance(context: Context): Database {
        return instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }

    private fun buildDatabase(context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).build()
    }
}