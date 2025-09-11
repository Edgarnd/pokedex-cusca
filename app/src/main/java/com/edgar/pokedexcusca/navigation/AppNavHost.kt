package com.edgar.pokedexcusca.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.edgar.pokedexcusca.ui.screen.SplashScreen
import com.edgar.pokemon.detail.PokemonDetailScreen
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
            PokemonListScreen(
                onPokemonClick = { url ->
                    val encodedUrl = Uri.encode(url)
                    navController.navigate("pokemon_detail/$encodedUrl")
                }
            )
        }
        composable(
            "pokemon_detail/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url")!!
            PokemonDetailScreen(navController, url = url)
        }
    }
}