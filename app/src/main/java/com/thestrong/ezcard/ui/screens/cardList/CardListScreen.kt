package com.thestrong.ezcard.ui.screens.cardList


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.thestrong.ezcard.ui.common.CardItem

@Composable
fun CardListScreen() {

    LazyColumn() {
        items(
            items = Array(3,{}),
            itemContent = {
                CardItem()
            })
    }
}