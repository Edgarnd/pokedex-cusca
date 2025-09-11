package com.edgar.pokemon.list.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.edgar.core.model.pokemon.Pokemon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.edgar.core.ui.text.capitalizeWords
import com.edgar.core.ui.text.toCardinal
import com.edgar.pokemon.list.PokemonListViewModel
import com.edgar.pokemon.list.R

@Composable
fun PokemonGrid(
    pokemons: List<Pokemon>,
    onLoadMore: () -> Unit,
    isLoading: Boolean
) {
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        state = listState,
    ) {
        items(pokemons.size) { index ->
            PokemonItemList(pokemon = pokemons[index])

            if (index == pokemons.size - 1 && !isLoading) {
                LaunchedEffect(Unit) {
                    onLoadMore()
                }
            }
        }
    }
}

@Composable
fun PokemonItemList(
    viewModel: PokemonListViewModel = hiltViewModel(),
    pokemon: Pokemon
){
    val detail = viewModel.pokemonsDetail[pokemon.name]
    var error by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(true) }
    val urlImage = detail?.sprites?.other?.home?.frontDefault ?: detail?.sprites?.other?.home?.frontDefault ?: detail?.sprites?.frontDefault

    LaunchedEffect(pokemon.url) {
        viewModel.getPokemonDetail(pokemon)
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Box(modifier = Modifier.padding(16.dp)) {

            if(detail == null){
                Text("Cargando…")
            } else {
                Column {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        Text(detail.id!!.toCardinal(),
                            color = if (isSystemInDarkTheme()) Color.White else Color.DarkGray)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        if(urlImage != null)
                            PokemonImage(
                                url = urlImage,
                                modifier = Modifier.size(92.dp)
                            )
                        else
                            Image(
                                painter = painterResource(com.edgar.core.ui.R.drawable.pokeball_header),
                                contentDescription = ""
                            )
                    }
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(pokemon.name.capitalizeWords(),
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.tertiary)
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonImage(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = url,
        contentDescription = "Pokemon image",
        modifier = modifier
    )
}