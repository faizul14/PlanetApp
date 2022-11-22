package com.example.planetapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlanetViewModel(val useCase: UseCase): ViewModel() {

    private val _data = MutableStateFlow(
        useCase.getPlanetList()
    )
    val data: StateFlow<List<PlanetModel>> get() = _data

    fun getPlanetSearch(query: String){
        viewModelScope.launch {
            _data.value = useCase.getPlanetSearch(query)
        }
    }
}