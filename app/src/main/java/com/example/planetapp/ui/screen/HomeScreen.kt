package com.example.planetapp.ui.screen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planetapp.R
import com.example.planetapp.core.data.fakedata.PlanetList
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.presentation.PlanetViewModel
import com.example.planetapp.presentation.ViewModelFactory
import com.example.planetapp.ui.common.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: PlanetViewModel = viewModel(factory = ViewModelFactory.getInstance()),
    navigateToDetail: (Int) -> Unit,
) {
    val data: List<PlanetModel> by viewModel.data.collectAsState()
    var dataSearch by rememberSaveable { mutableStateOf("") }
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(colorResource(id = R.color.bg))
    ) {
        Header()
        SearchBar(
            input = dataSearch,
            onChange = { data ->
                dataSearch = data
                viewModel.getPlanetSearch(data)
            }
        )
        SectionText(content = "Most Popular")
        if (data.isNotEmpty())
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(35.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {

                items(data) {
                    CardItem(photo = it.photoUrl, name = it.name, gradient = it.color,
                        modifier = Modifier
                            .animateItemPlacement(tween(durationMillis = 100))
                            .clickable {
                                navigateToDetail(it.id)
                            })

                }
            }
        else NoData()
        Spacer(modifier = modifier.padding(top = 10.dp))
        SectionText(content = "You may also like")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(PlanetList.planetShifled) {
                CardItemSecond(photo = it.photoUrl, name = it.name, gradient = it.color)
                modifier.clickable {
                    navigateToDetail(it.id)
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