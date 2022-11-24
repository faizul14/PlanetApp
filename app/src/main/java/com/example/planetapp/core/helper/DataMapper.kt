package com.example.planetapp.core.helper

import com.example.planetapp.core.data.fakedata.Planet
import com.example.planetapp.core.data.fakedata.PlanetFvorite
import com.example.planetapp.core.domain.model.PlanetModel

object DataMapper {
    fun mapDataToDataModel(input: List<Planet>) : List<PlanetModel>{
        val planetList = ArrayList<PlanetModel>()
        input.map {
            val planet = PlanetModel(
                id = it.id,
                name = it.name,
                photoUrl = it.photoUrl,
                color = it.color
            )
            planetList.addAll(listOf(planet))
        }
        return planetList
    }

    fun mapDataToDataModelFavorit(input: List<PlanetFvorite>): List<PlanetModel> {
        val planetList = ArrayList<PlanetModel>()
        input.map {
            val planet = PlanetModel(
                id = it.planet.id,
                name = it.planet.name,
                photoUrl = it.planet.photoUrl,
                color = it.planet.color,
            )
            planetList.addAll(listOf(planet))
        }
        return planetList
    }

    fun mapDataPlanetListToPlanetDetail(input: Planet): PlanetModel{
        return PlanetModel(
            id = input.id,
            name = input.name,
            photoUrl = input.photoUrl,
            color = input.color,
        )
    }
}