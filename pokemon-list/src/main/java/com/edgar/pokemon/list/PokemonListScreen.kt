package com.edgar.pokemon.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edgar.core.ui.header.PokedexHeader
import com.edgar.core.ui.loader.LoaderDialog
import com.edgar.pokemon.list.composable.PokemonGrid

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemons = viewModel.pokemons
    val error = viewModel.errorMessage

    Column(
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
        PokedexHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                append("¡Hola, ")
                pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                append("bienvenido")
                pop()
                append("!")
            },
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (error != null) {
            Text("Ocurrio un error: $error")
        } else {
            PokemonGrid(
                pokemons = pokemons,
                isLoading = viewModel.loading,
                onLoadMore = { viewModel.loadPokemons() }
            )
        }
    }
}