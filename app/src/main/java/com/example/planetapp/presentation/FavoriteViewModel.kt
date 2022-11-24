package com.example.planetapp.presentation

import androidx.lifecycle.ViewModel
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.domain.usecase.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoriteViewModel(val useCase: UseCase): ViewModel() {
    private val _data = MutableStateFlow(
        useCase.getPlanetFavorite()
    )
    val data : StateFlow<List<PlanetModel>> get() = _data
}