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

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.ItemData


object Constans {
    const val NAV_LIST = "list"

    const val NAV_DETAIL_ARG = "position"
    const val NAV_DETAIL = "detail/{$NAV_DETAIL_ARG}"

    fun buildPuppyDetailPath(position: Int) = "detail/${position}"


    val list = listOf(
        ItemData(
            name = "Cinnamon",
            image = R.drawable.puppy_1,
            age = 9
        ), ItemData(
            name = "Hershey",
            image = R.drawable.puppy_2,
            age = 9,
        ), ItemData(
            name = "Brooklyn",
            image = R.drawable.puppy_3,
            age = 9,
        ), ItemData(
            name = "Captain",
            image = R.drawable.puppy4,
            age = 9,
        ), ItemData(
            name = "Maximus",
            image = R.drawable.puppy_5,
            age = 9,
        ), ItemData(
            name = "Pumpkin",
            image = R.drawable.puppy_6,
            age = 9,
        ), ItemData(
            name = "Scrappy",
            image = R.drawable.puppy_7,
            age = 9,
        )
    )
}
