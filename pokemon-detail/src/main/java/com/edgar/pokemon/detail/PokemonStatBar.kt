package com.edgar.pokemon.detail

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edgar.core.ui.text.capitalizeWords

@Composable
fun PokemonStatBar(
    statName: String,
    baseStat: Long,
    typeColor: Color,
    typeSoftColor: Color,
    maxStat: Long = 255,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            text = statName.capitalizeWords(),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(0.4f)
        )

        Row (
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = typeSoftColor)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth((baseStat / maxStat.toFloat()).coerceIn(0f, 1f))
                        .fillMaxHeight()
                        .background(color = typeColor)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = baseStat.toInt().toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
    }
}
