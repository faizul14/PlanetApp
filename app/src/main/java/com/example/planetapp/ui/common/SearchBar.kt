package com.example.planetapp.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetapp.ui.theme.PlanetAppTheme
import okhttp3.internal.wait

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    input: String,
    onChange: (String) -> Unit,

) {
    TextField(
        value = input,
        onValueChange = onChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(com.example.planetapp.R.color.trp),
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.White,
        ),
        placeholder = {
            Text("Find galaxy.")
        },
        modifier = modifier
            .padding( 10.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    PlanetAppTheme {
//        SearchBar()
    }
}