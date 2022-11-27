package com.example.planetapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
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
    viewModel: FavoriteViewModel = viewModel(factory = ViewModelFactory.getInstance()),
    navigateToDetail: (Int) -> Unit
) {
    viewModel.getData()
    val data by viewModel.data.collectAsState()
    Box(
        modifier = modifier
            .padding(8.dp, bottom = 0.dp, end = 10.dp)
            .fillMaxSize()

    ) {
        Column {
            Text(
                text = "Favorite",
                color = Color.White,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 10.dp, top = 8.dp),

                )

            if (data?.isNotEmpty() == true)
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(vertical = 10.dp)
                ) {
                    items(data!!, key = { it.id }) {
                        CardItemFavovrite(
                            name = it.name,
                            photo = it.photoUrl,
                            gradient = it.color,
                            modifier = Modifier.clickable {
                                navigateToDetail(it.id)
                            }
                        )
                    }
                }
            else NoData()


        }

    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview() {
    PlanetAppTheme {
        FavoriteScreen(
            navigateToDetail = {}
        )
    }
}