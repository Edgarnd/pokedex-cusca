package com.edgar.pokemon.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edgar.core.model.pokemon.PokemonDetail
import com.edgar.core.model.pokemon.PokemonSpecies

@Composable
fun PokemonDetailContent(
    detail: PokemonDetail,
    speciesDescription: String
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        val urlImage = detail.sprites?.other?.home?.frontDefault ?: detail.sprites?.other?.home?.frontDefault ?: detail.sprites?.frontDefault

        PokemonDetailImage(
            imageUrl = urlImage,
            types = detail.types ?: emptyList(),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        PokemonDetailPhysic(pokemonDetail = detail)
        Spacer(modifier = Modifier.height(24.dp))
        Text(speciesDescription,
            fontSize = 14.sp,
            modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(24.dp))
        PokemonDetailStats(
            pokemonDetail = detail
        )
    }
}
