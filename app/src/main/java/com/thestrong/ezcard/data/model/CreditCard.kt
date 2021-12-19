package com.thestrong.ezcard.data.model

data class CreditCard(
    val cardHolderName: String,
    val cardNumber: String,
    val cvv2: Int,
    val expireDate: String,
    val bankName: String,
    val shaba: String,
    val details:String,
    val cardPass: String?,
    val pass2 :String?
)
