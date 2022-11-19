package com.example.planetapp.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun SectionText(
    modifier: Modifier = Modifier,
    content: String
) {
    Row(
        modifier.fillMaxWidth()
    ) {
        Text(
            text = content,
            Modifier.padding(8.dp),
            fontSize = 20.sp,
//            style = MaterialTheme.typography.subtitle1.copy(
//                fontWeight = FontWeight.ExtraBold
//            ),
            color = Color.White,
        )
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(18.dp).align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun SectionTextPreview() {
    PlanetAppTheme {
        SectionText(modifier = Modifier ,"")
    }
}