package com.example.planetapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun CardItemFavovrite(
    modifier: Modifier = Modifier,
    name: String,
    photo: String,
    gradient: List<Color>
) {

    Box(
        modifier = modifier
            .padding(start = 80.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp),
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(20.dp),
//            elevation = 7.dp,
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(brush = Brush.verticalGradient(colors = gradient))
            ) {
                Box(

                ) {

                }
            }
        }
        Image(
            painter = painterResource(id = com.example.planetapp.R.drawable.mars),
            contentDescription = null,
            modifier.align(Alignment.CenterStart)
                .size(140.dp)
                .offset(-80.dp, 0.dp)
        )
    }
}


@Preview
@Composable
fun CardItemFavovritePreview() {
    PlanetAppTheme {
        CardItemFavovrite(
            Modifier,
            "",
            "",
            listOf()

        )
    }
}