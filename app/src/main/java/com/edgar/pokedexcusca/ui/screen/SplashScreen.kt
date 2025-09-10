package com.edgar.pokedexcusca.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.edgar.pokedexcusca.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinishTime: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(3000L)
        onFinishTime()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val context = LocalContext.current

            val imageLoader = ImageLoader.Builder(context)
                .components {
                    add(GifDecoder.Factory())
                }
                .build()

            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data(R.drawable.pokeball_splash)
                    .build(),
                imageLoader = imageLoader
            )
            Image(
                painter = painter,
                contentDescription = ""
            )
        }
    }
}