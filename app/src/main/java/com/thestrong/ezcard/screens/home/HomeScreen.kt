package com.thestrong.ezcard.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.thestrong.ezcard.R
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

////                            background
//            Image(
//                imageVector = ImageVector.vectorResource(id = R.drawable.vector_background_home),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(),
//                contentScale = ContentScale.FillBounds,
//                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
//
//                )
//                            setup list of cards
//                CardList()

        }
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        HomeButton()
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        HomeButton()
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

