package com.example.planetapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .background(colorResource(id = com.example.planetapp.R.color.bg))
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        ImageLoad()
        Spacer(
            modifier = modifier
                .height(10.dp)
                .fillMaxWidth()
                .padding(top = 10.dp)
                .padding(bottom = 10.dp)
                .background(Color.White)
        )
        Line()
        Content()
    }
}

@Composable
fun ImageLoad(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxWidth()
            .height(400.dp),
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .clickable { },
        )
        Image(
            painter = painterResource(com.example.planetapp.R.drawable.mars),
            contentDescription = "imageclip",
            modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(CircleShape)
                .align(Alignment.Center)
                .padding(top = 20.dp)
                .offset(0.dp, -20.dp),
        )

        Column(
            modifier = modifier
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = "Mercury",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 30.sp,
            )
            Text(
                text = "Lorem Ipsum Dolor Is Amet",
                color = Color.White,
                fontSize = 16.sp,
                maxLines = 2,
                modifier = modifier.padding(top = 5.dp)
            )

        }

    }
}

@Composable
fun Line(
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.White)
    ) {

    }
}

@Composable
fun Content() {
    Text(
        text = stringResource(id = com.example.planetapp.R.string.ex_contnet),
        fontSize = 12.sp,
        color = Color.White,
        fontWeight = FontWeight.Medium

    )
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailScreenPreview() {
    PlanetAppTheme {
        DetailScreen()
    }
}