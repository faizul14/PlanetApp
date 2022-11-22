package com.example.planetapp.core.data

import com.example.planetapp.core.data.fakedata.PlanetList
import com.example.planetapp.core.domain.model.PlanetModel
import com.example.planetapp.core.domain.repository.IPlanetRepository
import com.example.planetapp.core.helper.DataMapper

class PlanetRepository : IPlanetRepository {
    companion object {
        @Volatile
        private var INSTANCE: PlanetRepository? = null

        fun getInstance(): PlanetRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: PlanetRepository()
            }
    }

    override fun getPlanetList(): List<PlanetModel> {
        return DataMapper.mapDataToDataModel(PlanetList.planet)
    }

    override fun getPlanetSearch(query: String): List<PlanetModel> {
        return DataMapper.mapDataToDataModel(PlanetList.planet.filter {
            it.name.contains(query, ignoreCase = true)
        })
    }

    override fun getDetail(id: Int): PlanetModel {
        val data = PlanetList.planet.first { it.id == id }
        return DataMapper.mapDataPlanetListToPlanetDetail(data)
    }


}