/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.ItemData

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
                // start = avatarWidth / 2,
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
