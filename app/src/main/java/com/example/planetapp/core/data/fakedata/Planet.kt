package com.example.planetapp.core.data.fakedata


data class Planet(
    val id: Int,
    val name: String,
    val photoUrl: String,
    val color: List<androidx.compose.ui.graphics.Color>
)
