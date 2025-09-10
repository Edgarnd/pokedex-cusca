package com.edgar.pokemon.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edgar.core.model.pokemon.Pokemon
import com.edgar.core.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    var pokemons by mutableStateOf<List<Pokemon>>(emptyList())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var loading by mutableStateOf(false)

    init {
        loadPokemons()
    }

    fun loadPokemons(page: Int = 0) {
        viewModelScope.launch {
            loading = true
            try {
                delay(2000L)
                val list = withContext(Dispatchers.IO){
                    repository.getPokemons(page)
                }
                pokemons = list
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                loading = false
            }
        }
    }
}