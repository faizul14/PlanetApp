package com.example.planetapp.core.data

import android.util.Log
import com.example.planetapp.core.data.fakedata.PlanetFvorite
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
//                INSTANCE ?: PlanetRepository()
                PlanetRepository().apply {
                    INSTANCE = this
                }
            }
    }

    private val PlanetF = mutableListOf<PlanetFvorite>()


    init {
        if (PlanetF.isEmpty()) {
            PlanetList.planet.forEach {
                PlanetF.add(PlanetFvorite(it, false))
            }
        }
    }

    override fun getPlanetList(): List<PlanetModel> {
//        return DataMapper.mapDataToDataModel(PlanetList.planet)
        return DataMapper.mapDataToDataModelFavorit(PlanetF)
    }

    override fun getPlanetSearch(query: String): List<PlanetModel> {
//        return DataMapper.mapDataToDataModel(PlanetList.planet.filter {
//            it.name.contains(query, ignoreCase = true)
//        })
        return DataMapper.mapDataToDataModelFavorit(PlanetF.filter {
            it.planet.name.contains(query, ignoreCase = true)
        })
    }

    override fun getDetail(id: Int): PlanetModel {
        val data = PlanetF.first { it.planet.id == id }
        return DataMapper.mapDataPlanetListToPlanetDetailPlanetF(data)
    }

    override fun getFavorite(): List<PlanetModel> {
//        return PlanetF.
//        map { orderRewards ->
//                orderRewards.filter { orderReward ->
//                    orderReward.count != 0
//                }
//            }
        return DataMapper.mapDataToDataModelFavorit(PlanetF.filter { it.isFavorite == true })

    }

    override fun setFavorite(id: Int, isFavorite: Boolean): Boolean {
//        val data = PlanetList.planet.first { it.id == id }
//        PlanetList.planetIsFavorite.addAll(
//            listOf(
//                Planet(
//                    id = data.id,
//                    name = data.name,
//                    photoUrl = data.photoUrl,
//                    color = data.color,
//                    isFavorite = true
//                )
//            )
//        )
//        return DataMapper.mapDataPlanetListToPlanetDetail(PlanetList.planetIsFavorite.first(){it.id == id})
//        val index = orderRewards.indexOfFirst { it.reward.id == rewardId }
//        val result = if (index >= 0) {
//            val orderReward = orderRewards[index]
//            orderRewards[index] =
//                orderReward.copy(reward = orderReward.reward, count = newCountValue)
//            true
//        } else {
//            false
//        }
//        return flowOf(result)
//    }
        Log.d("SETF", "id: $id, isFavorite: $isFavorite")
        val index = PlanetF.indexOfFirst {
            it.planet.id == id
        }

        val result = if (index >= 0) {
            val planetF = PlanetF[index]
            PlanetF[index] = planetF.copy(
                planet = planetF.planet, isFavorite = isFavorite
            )
            true
        } else {
            false
        }
        Log.d("SETF", "result $result")
        return result
    }


}