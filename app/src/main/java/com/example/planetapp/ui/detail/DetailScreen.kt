package com.example.planetapp.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun DetailScreen() {
    ImageLoad()
}

@Composable
fun ImageLoad(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxWidth()
    ) {
        Row(
            modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(18.dp)
                    .weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(18.dp),
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    PlanetAppTheme {
        DetailScreen()
    }
}