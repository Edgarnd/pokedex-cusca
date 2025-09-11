package com.edgar.pokemon.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edgar.core.model.pokemon.PokemonDetail
import com.edgar.core.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    var detail by mutableStateOf<PokemonDetail?>(null)
        private set

    var loading by mutableStateOf(false)

    var error by mutableStateOf<String?>(null)
        private set

    var speciesDescription by mutableStateOf<String?>(null)
        private set

    fun loadPokemonDetail(url: String) {
        viewModelScope.launch {
            loading = true
            error = null
            try {
                detail = withContext(Dispatchers.IO) {
                    repository.getPokemonDetail(url)
                }
                loadSpeciesDescription(detail!!.id!!.toInt())
            } catch (e: Exception) {
                error = e.message
            } finally {
                loading = false
            }
        }
    }

    fun loadSpeciesDescription(id: Int) {
        viewModelScope.launch {
            try {
                val species = withContext(Dispatchers.IO){
                    repository.getPokemonSpecies(id)
                }
                val flavor = species.flavorTextEntries.firstOrNull { it.language.name == "es" }?.flavorText
                speciesDescription = flavor?.replace("\n", " ")?.replace("\u000c", " ")
            } catch (e: Exception) {
                speciesDescription = "No description available"
            }
        }
    }
}