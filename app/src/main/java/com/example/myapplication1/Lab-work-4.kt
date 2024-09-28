package com.example.myapplication1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion.Monospace
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen() {
    val scope = rememberCoroutineScope()




    Scaffold(
        topBar = {
           TopAppBar(
                title = { Text("My First App", fontFamily = FontFamily.Monospace)  },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = "Menu")
                    }
                }
            )
        },


        bottomBar = {

            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                )
                {
                IconButton(onClick = { /**/ }) {
                    Icon(Icons.Filled.DateRange, contentDescription = "Home Icon", Modifier.size(52.dp))
                }

                IconButton(onClick = { /* Действие */ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home Icon",Modifier.size(52.dp))
                }
                IconButton(onClick = { /**/ }) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Home Icon",Modifier.size(52.dp))
                    Modifier.padding(46.dp)
                }}
            }
        },

    ) { padding ->
        padding
        Text("Main Content" )


        LazyColumn(
            modifier = Modifier.fillMaxWidth(),


        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(top=70.dp, bottom = 20.dp, start = 30.dp),
                    fontWeight = FontWeight.ExtraBold,

                    text = "Simple text, but contains in LazyColumn",
                            fontSize = 22.sp
                )
            }
            items(100) { index ->
                Row(modifier = Modifier
                    .border(0.4.dp, color = Color.Black,),
                    verticalAlignment = Alignment.CenterVertically)
                {

                    Image( painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Sample Image", modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.LightGray)
                            .size(70.dp)

                    )
Column {
    Text(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(start = 12.dp,top=9.dp),
        fontWeight = FontWeight.ExtraBold,
        text = "Chat number $index",
                fontSize = 20.sp
    )
    Text(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(8.dp),
        text = " I just want to see this text on two lines so that you can try to make a restriction",
        fontSize = 18.sp

    )


}

                }

            }
        }
    }
}




@Preview(showBackground = true)
@Composable
private fun PreviewSecondScreen() {
    SecondScreen()
}
