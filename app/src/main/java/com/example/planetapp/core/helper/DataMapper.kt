package com.example.planetapp.core.helper

import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.data.fakedata.Planet

object DataMapper {
    fun mapDataToDataModel(input: List<Planet>) : List<PlanetModel>{
        val planetList = ArrayList<PlanetModel>()
        input.map {
            val planet = PlanetModel(
                id = it.id,
                name = it.name,
                photoUrl = it.photoUrl,
                color = it.color,
            )
            planetList.addAll(listOf(planet))
        }
        return planetList
    }
}