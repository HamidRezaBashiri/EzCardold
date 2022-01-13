package com.thestrong.ezcard.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val password:String,
    val passwordReplace:String
)