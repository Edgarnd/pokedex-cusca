package com.edgar.pokemon.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.edgar.core.model.pokemon.Type
import com.edgar.core.ui.color.typeColors
import com.edgar.core.ui.color.typeEmoji
import com.edgar.core.ui.color.typeSoftColors
import com.edgar.core.ui.text.capitalizeWords

@Composable
fun PokemonDetailImage(
    imageUrl: String?,
    types: List<Type>,
    modifier: Modifier = Modifier,
    height: Dp = 300.dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomCenter)
                .background(typeColors[types.first().type?.name] ?: Color.Black,
                    shape = RoundedCornerShape(16))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.Center,
            ) {
                types.forEachIndexed { index, type ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = typeSoftColors[type.type?.name] ?: Color.DarkGray,
                                shape = RoundedCornerShape(50)
                            )
                            .border(
                                width = 2.dp,
                                color = typeSoftColors[type.type?.name] ?: Color.DarkGray,
                                shape = RoundedCornerShape(50)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            if(typeEmoji.containsKey(type.type?.name)){
                                Text(typeEmoji[type.type?.name] ?: "",
                                    style = MaterialTheme.typography.bodySmall)
                            } else {
                                Icon(
                                    painter = painterResource(com.edgar.core.ui.R.drawable.pokeball_header),
                                    contentDescription = type.type?.name,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Text(type.type?.name?.capitalizeWords() ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = typeColors[type.type?.name] ?: Color.White
                            )
                        }
                    }
                    if (index < types.lastIndex) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }

        if (!imageUrl.isNullOrEmpty()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Pokemon Image",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 64.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}