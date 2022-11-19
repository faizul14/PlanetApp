package com.example.planetapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planetapp.R
import com.example.planetapp.model.PlanetList
import com.example.planetapp.ui.common.CardItem
import com.example.planetapp.ui.common.Header
import com.example.planetapp.ui.common.SectionText

@Composable
fun HomeScreen(
    modifier : Modifier = Modifier
) {
    Column(
        modifier.background(colorResource(id = R.color.bg))
    ){
        Header()
        SectionText(content = "Most Popular")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(35.dp),
            contentPadding = PaddingValues(horizontal = 16.dp ),
        ){

            items(PlanetList.planet){
                CardItem(photo = it.photoUrl, name = it.name)
                modifier.clickable {  }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(

) {

}