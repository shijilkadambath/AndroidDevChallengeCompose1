package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
        DetailsToolbar(navController,item)
        DetailsImageView (item)
        Spacer(modifier = Modifier.requiredWidth(20.dp))
        DetailsView (item)
    }
}



@Composable
fun DetailsToolbar(navController: NavController,item:ItemData){
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
fun DetailsImageView(item:ItemData){

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
fun DetailsView(item:ItemData){
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth() .padding(start = 3.dp,end = 3.dp),
            text =  stringResource(R.string.dummy_text, "World"),
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