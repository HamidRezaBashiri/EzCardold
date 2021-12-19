package com.thestrong.ezcard.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thestrong.ezcard.R

@Composable
@Preview
fun HomeButton() {

    Button(
        onClick = fun() {}, modifier = Modifier
            .padding(2.dp)
            .clip(RoundedCornerShape(15))
    ) {
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(2.dp).weight(1f)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                contentDescription = "button icon",
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 12.dp)
                    .size(32.dp, 32.dp)
                    .clip(RoundedCornerShape(15))
                    .background(MaterialTheme.colors.onPrimary)
                    .padding(4.dp)

            )
            Text(
                fontSize = 12.sp,
                text = "تنظیمات",
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 6.dp),
                fontSize = 11.sp,
                text = "تنظیمات جامع اپلیکیشن",
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.h1
            )

        }
    }

}