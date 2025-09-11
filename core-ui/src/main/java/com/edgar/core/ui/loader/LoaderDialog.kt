package com.edgar.core.ui.loader

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.edgar.core.ui.R

@Composable
fun LoaderDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Surface (
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(256.dp)
                ) {
                    val context = LocalContext.current

                    val imageLoader = ImageLoader.Builder(context)
                        .components {
                            add(GifDecoder.Factory())
                        }
                        .build()

                    val painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(context)
                            .data(R.drawable.pokeball_loader)
                            .build(),
                        imageLoader = imageLoader
                    )
                    Image(
                        painter = painter,
                        contentDescription = "Cargando..."
                    )
                }
            }
        }
    }
}