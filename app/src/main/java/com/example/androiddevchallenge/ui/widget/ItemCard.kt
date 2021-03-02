package com.example.androiddevchallenge.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.ItemData
import java.util.*

@Composable
fun ItemCard(
    item: ItemData,
    onClick: () -> Unit,
) {
    val favState = remember { mutableStateOf(false) }
    val verticalDistanceFromAvatar = 3.dp
    Card(
        modifier = Modifier
            .padding(
                top = verticalDistanceFromAvatar,
                //start = avatarWidth / 2,
                bottom = verticalDistanceFromAvatar,
            )
            .height(120.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
    ) {
        Row(modifier = Modifier.primaryClick(onClick = onClick)) {
            Image(
                painter = painterResource(item.image),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        end = 8.dp,
                    )
            ) {
                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(48.dp),
                    onClick = { favState.value = !favState.value }
                ) {
                    Icon(
                        imageVector = if (favState.value) {
                            Icons.Default.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = "Favorite",
                        tint = if (favState.value) {
                            MaterialTheme.colors.primary
                        } else {
                            MaterialTheme.colors.onBackground
                        }
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = item.name,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${item.age} years old",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.60f)
                    )
                }
            }
        }
    }
}

fun Modifier.primaryClick(
    alpha: Float = 0.20f,
    onClick: () -> Unit
) = composed {
    coloredClick(color = MaterialTheme.colors.primary, alpha = alpha, onClick = onClick)
}

fun Modifier.coloredClick(
    color: Color,
    alpha: Float = 0.20f,
    onClick: () -> Unit
) = composed {
    clickable(
        indication = rememberRipple(color = color.copy(alpha = alpha)),
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
}