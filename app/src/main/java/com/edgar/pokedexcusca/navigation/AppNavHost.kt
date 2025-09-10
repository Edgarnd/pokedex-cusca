package com.edgar.pokedexcusca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edgar.pokedexcusca.ui.screen.SplashScreen
import com.edgar.pokemon.list.PokemonListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen {
                navController.navigate("pokemon_list") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
        composable("pokemon_list") {
            PokemonListScreen()
        }
//        composable(
//            "pokemon_detail/{id}",
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val id = backStackEntry.arguments?.getInt("id") ?: 0
//            PokemonDetailScreen(pokemonId = id)
//        }
    }
}