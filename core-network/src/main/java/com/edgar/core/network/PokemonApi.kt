package com.edgar.core.network

import com.edgar.core.model.pokemon.Pokemon
import com.edgar.core.model.pokemon.PokemonDetail
import com.edgar.core.model.response.PokemonResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonApi @Inject constructor (
    private val client: OkHttpClient,
    private val gson: Gson
) {
    private val baseUrl = "https://pokeapi.co/api/v2/"

    suspend fun getPokemonList(limit: Int = 20, offset: Int = 0): PokemonResponse {
        val request = Request.Builder()
            .url("${baseUrl}pokemon?limit=$limit&offset=$offset")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("HTTP error ${response.code}")
            val body = response.body?.string() ?: ""
            return gson.fromJson(body, PokemonResponse::class.java)
        }
    }

    suspend fun getPokemonDetail(url: String): PokemonDetail {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("HTTP error ${response.code}")
            val body = response.body?.string() ?: ""
            return gson.fromJson(body, PokemonDetail::class.java)
        }
    }

    suspend fun getAllPokemons(): PokemonResponse {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("HTTP error ${response.code}")
            val body = response.body?.string() ?: ""
            return gson.fromJson(body, PokemonResponse::class.java)
        }
    }
}