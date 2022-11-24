package com.example.planetapp.core.domain.model


data class PlanetModel(
    val id: Int,
    val name: String,
    val photoUrl: String,
    val color: List<androidx.compose.ui.graphics.Color>,
    val isFavorite: Boolean
)
