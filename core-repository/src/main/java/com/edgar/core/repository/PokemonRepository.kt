package com.edgar.core.repository

import com.edgar.core.model.pokemon.Pokemon
import com.edgar.core.network.PokemonApi
import com.edgar.core.model.pokemon.PokemonDetail
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

    suspend fun getPokemonDetail(id: Int): PokemonDetail {
        return api.getPokemonDetail(id)
    }
}