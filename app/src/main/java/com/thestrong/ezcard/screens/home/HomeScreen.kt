package com.thestrong.ezcard.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.thestrong.ezcard.data.model.CreditCard
import com.thestrong.ezcard.ui.common.HomeButton


@Composable
fun HomeScreen() {
    // A surface container using the 'background' color from the theme
//            Main Column

    Column(modifier = Modifier.fillMaxSize()) {
//                        box of toolbar and card list
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {


        }
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                .background(MaterialTheme.colors.surface)
                .padding(16.dp)

        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "description",
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(15.dp))
                                .background(MaterialTheme.colors.onPrimary)

                        )
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        HomeButton(
                            modifier = Modifier.padding(2.dp),
                            "نمایش جزيیات کارت",
                            "برای نمایش جزییات کارت کلیک کنید "
                        )
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        HomeButton( modifier = Modifier.padding(2.dp),
                            "نمایش جزيیات کارت",
                            "برای نمایش جزییات کارت کلیک کنید ")
                    }
                }

            }
        }
    }


}


@Composable
private fun CardList(cardList: ArrayList<CreditCard>) {
    LazyRow(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = cardList) { card ->
            CardItem(card)
        }
    }

}

@Composable
private fun CardItem(card: CreditCard) {

}

