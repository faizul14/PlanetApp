package com.example.planetapp.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planetapp.R
import com.example.planetapp.presentation.FavoriteViewModel
import com.example.planetapp.presentation.ViewModelFactory
import com.example.planetapp.ui.common.CardItemFavovrite
import com.example.planetapp.ui.common.NoData
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
        .background(colorResource(id = R.color.bg)),
    viewModel: FavoriteViewModel = viewModel(factory = ViewModelFactory.getInstance())
) {
    viewModel.getData()
    val data by viewModel.data.collectAsState()
    Log.d("Data", data.toString())
//    PlanetContent(state = data)
    Box(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()

    ) {
//        Text(
//            text = "Favorite",
//            modifier = modifier.align(Alignment.Center),
//            color = Color.White
//        )

        if (data?.isNotEmpty() == true)
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                items(data!!) {
                    CardItemFavovrite(
                        name = it.name,
                        photo = it.photoUrl,
                        gradient = it.color
                    )
                }
            }
        else NoData()

    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    PlanetAppTheme {
        FavoriteScreen()
    }
}