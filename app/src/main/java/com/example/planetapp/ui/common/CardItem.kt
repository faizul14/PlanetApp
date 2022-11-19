package com.example.planetapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.planetapp.R
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    photo: String,
    name: String,
) {
    Box(
        modifier
            .height(250.dp)
            .width(160.dp)
    ) {


        Card(
            modifier
                .fillMaxWidth()
                .height(210.dp)
//                    .width(200.dp)
//                    .height(250.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier.padding(10.dp)
            ) {
                Text(
                    text = name,
                    Modifier.padding(bottom = 2.dp),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    fontSize = 20.sp
                )
                Text(
                    text = "Lorem Ipsum Dolor Is Amet",
                    maxLines = 2,
                    fontSize = 12.sp
                )
            }
        }
        AsyncImage(
            model = photo,
            contentDescription = "image",
            modifier
                .height(200.dp)
                .width(200.dp)
//                .fillMaxHeight()
//                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.Center)
                .offset(30.dp, -40.dp)
//                .border(5.dp, colorResource(id = R.color.bg), CircleShape)
        )

    }
//    Card(
//        modifier
//            .width(200.dp)
//            .height(250.dp)
//            .background(Color.Transparent),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Column {
//            Image(
//                painter = painterResource(R.drawable.mars),
//                contentDescription = "image",
//                modifier
//                    .height(200.dp)
//                    .width(160.dp)
//                    .fillMaxWidth()
//                    .padding(10.dp)
//                    .align(Alignment.CenterHorizontally)
//                    .offset(0.dp, -90.dp)
//            )
//            Text(
//                text = name,
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis,
//                style = MaterialTheme.typography.subtitle1.copy(
//                    fontWeight = FontWeight.ExtraBold
//                ),
//            )
//        }
//    }
}

@Preview
@Composable
fun CardItemPreview() {
    PlanetAppTheme {
        CardItem(
            modifier = Modifier,
            "",
            ""
        )
    }
}