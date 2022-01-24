package com.thestrong.ezcard.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.thestrong.ezcard.R
import com.thestrong.ezcard.data.model.CreditCard
import com.thestrong.ezcard.ui.common.HomeButton
import org.koin.androidx.compose.viewModel


@Composable
fun HomeScreen() {
// A surface container using the 'background' color from the theme
//Main Column
    val viewModel by viewModel<HomeViewModel>()

    Column(modifier = Modifier.fillMaxSize()) {
//box of toolbar and card list
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            LazyRow() {

//            TODO    after addeing card list  un comment this for show ing rv
//                items(
//                    items = CreditCard,
//                    itemContent = {
//                        CardItem( card =  it)
//                    })
            }

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
                    Text(
                        text = "description",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colors.onPrimary)

                    )
                }
                HomeButton(
                    modifier = Modifier.padding(2.dp),
                    "نمایش جزيیات کارت",
                    "برای نمایش جزییات کارت کلیک کنید ",
                    id = R.drawable.ic_card_details

                )

                HomeButton(
                    modifier = Modifier.padding(2.dp),
                    "اشتراک گذاری سریع",
                    "برای اشتراک گزاری سری کلیک کنید ",
                    id = R.drawable.ic_card_details
                )


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

