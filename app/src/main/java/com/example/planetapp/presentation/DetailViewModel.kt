package com.example.planetapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.domain.usecase.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val useCase: UseCase) : ViewModel() {
    private val _data : MutableStateFlow<PlanetModel?> = MutableStateFlow(null)
    val data: StateFlow<PlanetModel?> get() = _data

    fun getPlanetId(id: Int){
        viewModelScope.launch {
            _data.value = useCase.getPlanetDetail(id)
        }
    }

    fun setFavorite(id: Int, isFavorite: Boolean){
        viewModelScope.launch {
            useCase.setPlanetFavorite(id = id, isFavorite = isFavorite)
        }
    }


}