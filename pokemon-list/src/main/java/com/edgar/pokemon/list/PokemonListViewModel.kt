package com.edgar.pokemon.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edgar.core.model.pokemon.Pokemon
import com.edgar.core.model.pokemon.PokemonDetail
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
    private val _pokemonsDetail = mutableStateMapOf<String, PokemonDetail?>()
    val pokemonsDetail: Map<String, PokemonDetail?> get() = _pokemonsDetail

    var pokemons by mutableStateOf<List<Pokemon>>(emptyList())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var loading by mutableStateOf(false)

    var loadingList by mutableStateOf(false)

    var query by mutableStateOf("")

    private var allPokemons: List<Pokemon> = emptyList()

    private var currentPage = 0
    private var isLastPage = false

    init {
        loadPokemons()
        loadAllPokemons()
    }

    fun loadPokemons() {
        if (loadingList || isLastPage) return

        viewModelScope.launch {
            loadingList = true
            try {
                val list = withContext(Dispatchers.IO) {
                    repository.getPokemons(currentPage)
                }

                if (list.isEmpty()) {
                    isLastPage = true
                } else {
                    currentPage++
                    pokemons = pokemons + list
                    errorMessage = null
                }
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                loadingList = false
            }
        }
    }

    fun getPokemonDetail(pokemon: Pokemon) {
        if (_pokemonsDetail.containsKey(pokemon.name)) return
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO){
                    repository.getPokemonDetail(pokemon.url)
                }
                _pokemonsDetail[pokemon.name] = result
            } catch (_: Exception) {
            }
        }
    }

    private fun loadAllPokemons() {
        viewModelScope.launch {
            loading = true
            try {
                delay(2000L)
                val list = withContext(Dispatchers.IO) {
                    repository.getAllPokemons()
                }
                allPokemons = list
                pokemons = list.take(20)
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                loading = false
            }
        }
    }

    fun searchPokemons(query: String) {
        if (query.isBlank()) {
            pokemons = allPokemons.take(20)
            return
        }

        pokemons = allPokemons.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}