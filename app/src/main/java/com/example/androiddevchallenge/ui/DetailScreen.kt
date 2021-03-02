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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.ItemData

@Composable
fun DetailsScreen(
    navController: NavController,
    position: Int
) {
    val item = Constans.list.get(position)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.background)

    ) {
        DetailsToolbar(navController, item)
        DetailsImageView(item)
        Spacer(modifier = Modifier.requiredWidth(20.dp))
        DetailsView(item)
    }
}


@Composable
fun DetailsToolbar(navController: NavController, item: ItemData) {
    TopAppBar(
        title = {
            Text(text = item.name)
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                //Icon(Icons.Filled.Menu)
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Composable
fun DetailsImageView(item: ItemData) {

    Image(
        painter = painterResource(item.image),
        contentDescription = null,
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun DetailsView(item: ItemData) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 3.dp, end = 3.dp),
            text = stringResource(R.string.dummy_text, "World"),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.60f)
        )
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .requiredHeight(48.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary
            ),
            onClick = { }
        ) {
            Text("Adopt Now")
        }
    }
}