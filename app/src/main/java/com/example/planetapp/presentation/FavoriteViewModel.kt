package com.example.planetapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.domain.usecase.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(val useCase: UseCase): ViewModel() {
    private val _data:  MutableStateFlow<List<PlanetModel>?> = MutableStateFlow(
        null
    )
    val data : StateFlow<List<PlanetModel>?> get() = _data

    fun getData(){
        viewModelScope.launch {
            _data.value = useCase.getPlanetFavorite()
        }
    }

//    private val _data2: MutableStateFlow<CardState> = MutableStateFlow()
//    fun getFavorite(){
//        viewModelScope.launch {
//            useCase.getPlanetFavorite().asFlow().collect{data->
//                val aa = data.isFavorite
//                _data.value = (CardState(listOf(data), aa))
//            }
//        }
//    }

}