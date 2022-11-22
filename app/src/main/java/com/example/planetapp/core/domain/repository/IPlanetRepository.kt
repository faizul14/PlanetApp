package com.example.planetapp.core.domain.repository

import com.example.planetapp.core.domain.model.PlanetModel

interface IPlanetRepository {
    fun getPlanetList() : List<PlanetModel>

    fun getPlanetSearch(query: String) : List<PlanetModel>

    fun getDetail(id: Int) : PlanetModel


}