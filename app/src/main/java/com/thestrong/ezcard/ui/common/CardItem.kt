package com.thestrong.ezcard.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thestrong.ezcard.R

@Composable
fun CardItem() {

    Column(
        modifier = Modifier.padding(8.dp)
            .clip(RoundedCornerShape(16))
            .background(color = Color.Cyan)
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_wallet),
                contentDescription = "icon"
            )
        }
        Column(
            modifier = Modifier
                .padding(4.dp)
                .padding(top = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "6104 3377 7787 4837",
                fontSize = 22.sp
            )
            Text(
                text = "IR20 0000 0000 3377 7787 4837",
                fontSize = 12.sp,
                modifier = Modifier.padding(4.dp)
            )

        }
        Row(Modifier.padding(4.dp)) {
            Text(text = "name")

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "cvv2",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(4.dp)
                )
                Text(text = "567")
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "تاریخ انقضا", fontSize = 12.sp, modifier = Modifier.padding(4.dp))
                Text(text = "99/10")

            }
        }
    }
}