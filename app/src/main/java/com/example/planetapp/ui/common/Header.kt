package com.example.planetapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetapp.R
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun Header(
    modifier: Modifier = Modifier.padding( bottom = 5.dp)
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier.weight(1f)
        ) {
            Text(
                text = "Let's Explore",
                color = Color.White,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(text = "The milky way galaxy", color = Color.White)
        }
        Box(
            modifier
                .align(Alignment.CenterVertically)
                .clickable { }
        ) {
            Image(
                painter = painterResource(R.drawable.mars),
                contentDescription = "imageclip",
                modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape),
            )
            Icon(
                imageVector = Icons.Default.CheckCircle,
                tint = Color.Green,
                contentDescription = "icon",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(20.dp)
                    .offset(0.dp, -5.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    PlanetAppTheme {
        Header()
    }
}