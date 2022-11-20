package com.example.planetapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorLong
import coil.compose.AsyncImage
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun CardItemSecond(
    modifier: Modifier = Modifier.padding(bottom = 10.dp),
    photo: String,
    name: String,
    gradient: List<Color>
) {
    Box(
        modifier
            .height(200.dp)
            .width(150.dp)
    ) {

        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.BottomCenter),
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(20.dp),
            elevation = 7.dp

        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier
//                    .background(brush = Brush.horizontalGradient(colors = gradient))
                    .padding(10.dp),

                ) {
                AsyncImage(
                    model = photo,
                    contentDescription = "image",
                    modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(10.dp)
                )
                Text(
                    text = name,
                    Modifier.padding(bottom = 2.dp),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "Lorem Ipsum Dolor Is Amet",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
//        AsyncImage(
//            model = photo,
//            contentDescription = "image",
//            modifier
//                .height(200.dp)
//                .width(200.dp)
//                .padding(10.dp)
//                .align(Alignment.Center)
//                .offset(30.dp, -40.dp)
//        )

    }
}

@Preview
@Composable
fun CardItemSecondPreview() {
    PlanetAppTheme {
        CardItemSecond(
            modifier = Modifier,
            "", "haha", listOf()
        )
    }
}