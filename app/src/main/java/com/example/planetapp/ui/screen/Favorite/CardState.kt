package com.example.planetapp.ui.screen.Favorite

import com.example.planetapp.core.data.fakedata.Planet
import com.example.planetapp.core.domain.model.PlanetModel

data class CardState(
    val planet: List<PlanetModel>,
    val isFavorite : Boolean
)
