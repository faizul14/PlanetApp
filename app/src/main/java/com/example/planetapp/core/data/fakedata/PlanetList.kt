package com.example.planetapp.core.data.fakedata

import android.graphics.Color.rgb
import androidx.compose.ui.graphics.Color

object PlanetList {
    val planet = listOf(
        Planet(
            id = 1,
            name = "Earth",
            photoUrl = "https://raw.githubusercontent.com/ezoniskandar/GoGreen/main/ImagesData/img/earth.webp",
            color = listOf(Color(84,210,239), Color(39,216,56)),
        ),
        Planet(
            id = 2,
            name = "Mars",
            photoUrl = "https://raw.githubusercontent.com/ezoniskandar/GoGreen/main/ImagesData/img/mars.webp",
            color = listOf(Color(243,93,68), Color(211,70,66)),
        ),
        Planet(
            id = 3,
            name = "Mercury",
            photoUrl = "https://raw.githubusercontent.com/ezoniskandar/GoGreen/main/ImagesData/img/mercury.webp",
            color = listOf(Color(rgb(190,90,38)), Color(rgb(237,142,47))),
        ),
        Planet(
            id = 4,
            name = "Moon",
            photoUrl = "https://raw.githubusercontent.com/ezoniskandar/GoGreen/main/ImagesData/img/moon.webp",
            color = listOf(Color(rgb(183,183,183)), Color(rgb(225,224,220))),
        ),
        Planet(
            id = 5,
            name = "Neptun",
            photoUrl = "https://raw.githubusercontent.com/ezoniskandar/GoGreen/main/ImagesData/img/neptune.webp",
            color = listOf(Color(rgb(27,118,192)), Color(rgb(32,141,232))),
        ),
    )

    val planetShifled = planet.shuffled()
}