package com.edgar.pokedexcusca.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinishTime: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000L)
        onFinishTime()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = android.R.drawable.star_on),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Pokedex",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}