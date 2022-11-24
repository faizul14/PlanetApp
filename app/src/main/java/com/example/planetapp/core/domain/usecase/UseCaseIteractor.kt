package com.example.planetapp.core.domain.usecase

import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.domain.repository.IPlanetRepository
import kotlinx.coroutines.flow.Flow

class UseCaseIteractor(val repository: IPlanetRepository) : UseCase {
    override fun getPlanetList(): List<PlanetModel>{
        return repository.getPlanetList()
    }

    override fun getPlanetSearch(query: String): List<PlanetModel> {
        return repository.getPlanetSearch(query = query)
    }

    override fun getPlanetDetail(id: Int): PlanetModel {
        return repository.getDetail(id)
    }

    override fun setPlanetFavorite(id: Int, isFavorite: Boolean): Boolean {
        return repository.setFavorite(id, isFavorite)
    }

    override fun getPlanetFavorite(): List<PlanetModel> {
        return repository.getFavorite()
    }
}