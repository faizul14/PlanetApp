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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    photo: String,
    name: String,
    gradient: List<Color>
) {
    Box(
        modifier
            .height(250.dp)
            .width(160.dp)
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(210.dp)
                .align(Alignment.BottomCenter),
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(20.dp),
            elevation = 7.dp

        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier
                    .background(brush = Brush.horizontalGradient(colors = gradient))
                    .padding(10.dp),

                ) {
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
                    maxLines = 2,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
        AsyncImage(
            model = photo,
            contentDescription = "image",
            modifier
                .height(200.dp)
                .width(200.dp)
                .padding(10.dp)
                .align(Alignment.Center)
                .offset(30.dp, -40.dp)
        )

    }
}

@Preview
@Composable
fun CardItemPreview() {
    PlanetAppTheme {
        CardItem(
            modifier = Modifier,
            "",
            "",
            listOf()
        )
    }
}