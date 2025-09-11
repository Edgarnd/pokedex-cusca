package com.edgar.pokemon.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.edgar.core.ui.R
import com.edgar.core.ui.header.PokemonHeader
import com.edgar.core.ui.loader.LoaderDialog
import com.edgar.core.ui.text.capitalizeWords
import com.edgar.core.ui.text.toCardinal

@Composable
fun PokemonDetailScreen(
    navController: NavController,
    url: String,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val detail = viewModel.detail
    val speciesDescription = viewModel.speciesDescription
    val loading = viewModel.loading
    val error = viewModel.error

    LaunchedEffect(url) {
        viewModel.loadPokemonDetail(url)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 16.dp,
                start = 24.dp,
                end = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoaderDialog(
            show = viewModel.loading,
            onDismiss = { viewModel.loading = false }
        )
        PokemonHeader(
            title = detail?.name?.capitalizeWords() ?: "Pokemon",
            subtitle = detail?.id?.toCardinal() ?: ""
        ) { navController.popBackStack() }
        Spacer(modifier = Modifier.height(16.dp))
        if (error != null) {
            Text("Ocurrio un error: $error")
            Button(
                onClick = {
                    viewModel.loadPokemonDetail(url)
                }
            ){
                Text("Reintentar")
            }
        } else {
            if(detail != null && !loading) {
                PokemonDetailContent(detail, speciesDescription ?: "")
            } else {
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
