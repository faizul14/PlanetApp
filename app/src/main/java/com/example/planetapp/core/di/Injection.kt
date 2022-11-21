package com.example.planetapp.core.di

import com.example.planetapp.core.data.PlanetRepository
import com.example.planetapp.core.domain.repository.IPlanetRepository
import com.example.planetapp.core.domain.usecase.UseCase
import com.example.planetapp.core.domain.usecase.UseCaseIteractor

object Injection {
    private fun provideRespository() : IPlanetRepository {
        val repos = PlanetRepository.getInstance()
        return repos
    }

    fun provideUseCase() : UseCase {
        return UseCaseIteractor(provideRespository())
    }
}