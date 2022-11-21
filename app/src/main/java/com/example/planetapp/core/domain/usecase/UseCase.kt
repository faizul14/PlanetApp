package com.example.planetapp.core.domain.usecase

import com.example.planetapp.core.domain.model.PlanetModel
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getPlanetList() : List<PlanetModel>
}