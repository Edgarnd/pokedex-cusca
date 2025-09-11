package com.edgar.pokemon.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edgar.core.model.pokemon.PokemonDetail
import com.edgar.core.ui.color.typeColors
import com.edgar.core.ui.color.typeSoftColors

@Composable
fun PokemonDetailStats (
    pokemonDetail: PokemonDetail
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Estadísticas",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
            )
        Spacer(modifier = Modifier.height(12.dp))
        pokemonDetail.stats?.forEachIndexed { index, stat ->
            val type = pokemonDetail.types?.firstOrNull()?.type?.name ?: "normal"
            PokemonStatBar(
                statName = stat.stat?.name ?: "",
                baseStat = stat.baseStat ?: 0,
                typeColor = typeColors[type] ?: Color.Gray,
                typeSoftColor = typeSoftColors[type] ?: Color.LightGray
            )
            if (index < pokemonDetail.stats!!.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}