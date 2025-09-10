package com.edgar.pokemon.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemons = viewModel.pokemons
    val error = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (error != null) {
            Text("Error: $error")
        } else if (pokemons.isEmpty()) {
            Text("Cargando Pokémon…")
        } else {
            LazyColumn {
                items(pokemons) { pokemon ->
                    Text(pokemon.name, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}