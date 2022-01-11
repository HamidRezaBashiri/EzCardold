package com.thestrong.ezcard.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thestrong.ezcard.R

@Composable

fun HomeButton(
    modifier: Modifier,
    title: String,
    subtitle: String,
    id: Int = R.drawable.ic_card_details
) {

    Button(
        onClick = fun() {}, modifier = Modifier
            .padding(2.dp)
            .clip(RoundedCornerShape(15))
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.End
        ) {
            Column(horizontalAlignment = Alignment.End, modifier = Modifier) {
                Text(
                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
                    fontSize = 12.sp,
                    text = title,
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(0.dp, 2.dp, 2.dp, 6.dp),
                    fontSize = 11.sp,
                    text = subtitle,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1
                )
            }


            Image(
                imageVector = ImageVector.vectorResource(id = id),
//                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                contentDescription = "button icon",
                modifier = Modifier
                    .padding(12.dp, 6.dp, 0.dp, 8.dp)
                    .size(32.dp, 32.dp)
                    .clip(RoundedCornerShape(15))


                )


        }
    }

}