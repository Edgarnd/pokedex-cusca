package com.edgar.core.repository

import com.edgar.core.model.pokemon.Pokemon
import com.edgar.core.network.PokemonApi
import com.edgar.core.model.pokemon.PokemonDetail
import com.edgar.core.model.pokemon.PokemonSpecies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {
    private val paginationQuantity = 20

    suspend fun getPokemons(page: Int): List<Pokemon> {
        val offset = page * paginationQuantity
        val response = api.getPokemonList(limit = paginationQuantity, offset = offset)
        return response.results
    }

    suspend fun getPokemonDetail(url: String): PokemonDetail {
        return api.getPokemonDetail(url)
    }

    suspend fun getAllPokemons(): List<Pokemon> {
        return api.getAllPokemons().results
    }

    suspend fun getPokemonSpecies(id: Int): PokemonSpecies {
        return api.getPokemonSpecies(id)
    }
}