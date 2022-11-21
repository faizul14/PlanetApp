package com.example.planetapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetapp.R
import com.example.planetapp.core.data.fakedata.PlanetList
import com.example.planetapp.presentation.PlanetViewModel
import com.example.planetapp.ui.common.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.presentation.ViewModelFactory


@Composable
fun HomeScreen(
    modifier : Modifier = Modifier,
    viewModel: PlanetViewModel = viewModel(factory = ViewModelFactory.getInstance())
) {
    val data: List<PlanetModel> by viewModel.data.collectAsState()
    var dataSearch by remember { mutableStateOf("") }
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding->
        Column(
            modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(colorResource(id = R.color.bg))
                .padding(innerPadding)
        ) {
            Header()
            SearchBar(
                input = dataSearch,
                onChange = {data ->
                    dataSearch = data
                }
            )
            SectionText(content = "Most Popular")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(35.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {

                items(data) {
                    CardItem(photo = it.photoUrl, name = it.name, gradient = it.color)
                    modifier.clickable { }
                }
            }
            Spacer(modifier = modifier.padding(top = 10.dp))
            SectionText(content = "You may also like")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                ){
                items(PlanetList.planetShifled) {
                    CardItemSecond(photo = it.photoUrl, name = it.name, gradient = it.color)
                    modifier.clickable { }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(

) {

}