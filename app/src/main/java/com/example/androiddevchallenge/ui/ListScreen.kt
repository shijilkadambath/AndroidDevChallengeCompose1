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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.widget.ItemCard

@Composable
fun ListScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)

    ) {
        Toolbar()
        PuppyList(navController)
    }
}

@Composable
fun PuppyList(navController: NavController) {
    val list = Constans.list

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        itemsIndexed(list) { index, puppy ->
            ItemCard(
                item = puppy,
                onClick = {
                    navController.navigate(Constans.buildPuppyDetailPath(index))
                }
            )
        }
    }
}

@Composable
fun Toolbar() {

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart,
    ) {
        TopAppBar(
            title = {
                Text(text = "")
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            contentColor = Color.White,
            elevation = 12.dp
        )

        Row(
            modifier = Modifier
                .padding(8.dp, 0.dp, 8.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.White,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Chennai",
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
            )
        }

        Icon(
            modifier = Modifier
                .height(20.dp)
                .padding(10.dp, 0.dp, 10.dp, 0.dp)
                .align(Alignment.CenterEnd),
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = Color.White,
        )
    }
}
