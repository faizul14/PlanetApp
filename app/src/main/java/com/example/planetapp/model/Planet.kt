package com.example.planetapp.model


data class Planet(
    val id: Int,
    val name: String,
    val photoUrl: String,
    val color: List<androidx.compose.ui.graphics.Color>
)
