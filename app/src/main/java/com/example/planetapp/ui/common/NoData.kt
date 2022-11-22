package com.example.planetapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.planetapp.R
import com.example.planetapp.ui.theme.PlanetAppTheme

@Composable
fun NoData(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .height(250.dp)
            .fillMaxWidth()
            .background(colorResource(id = R.color.bg))
    ) {
//        Image(
//            painter = painterResource(id = com.example.planetapp.R.drawable.notdatatr),
//            contentDescription = null,
//            contentScale = ContentScale.FillBounds,
//            modifier = modifier.align(Alignment.Center)
//        )

        val composition by rememberLottieComposition(

            LottieCompositionSpec
                // here `code` is the file name of lottie file
                // use it accordingly
                .RawRes(R.raw.nodata)
        )

        // to control the animation
        val progress by animateLottieCompositionAsState(
            // pass the composition created above
            composition,

            // Iterates Forever
            iterations = LottieConstants.IterateForever,

            // pass isPlaying we created above,
            // changing isPlaying will recompose
            // Lottie and pause/play
            isPlaying = true,

            // pass speed we created above,
            // changing speed will increase Lottie
            speed = 1f,

            // this makes animation to restart
            // when paused and play
            // pass false to continue the animation
            // at which is was paused
            restartOnPlay = false

        )
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.height(250.dp)
        )

    }

}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun NoDataPreviewe() {
    PlanetAppTheme {
        NoData()
    }
}