package com.example.assignment2.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Screen3(
    onTwoButtonClicked : () -> Unit,
    onOneButtonClicked : () -> Unit
) {
    var list by rememberSaveable { mutableStateOf(listOf<Any>()) }
    var count by rememberSaveable { mutableStateOf(0) }
    val sequence = ('a'..'z') + ('a'..'z').map { "a$it" } + ('a'..'z').map { "b$it" }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.weight(1f)
        ) {
            items(list.size) {
                Text(text = list[it].toString() , modifier = Modifier.padding(60.dp) , fontSize = 25.sp)
            }
        }
        NavigationBar(
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ) {
                Button(onClick = onTwoButtonClicked,
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp)) {
                    Text(text = "2")
                }
                Button(onClick = onOneButtonClicked,
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp)) {
                    Text(text = "1")
                }
                Button(onClick = {
                    if (count < sequence.size) {
                        list = list + sequence[count]
                        count++
                    }
                }, modifier = Modifier.padding(top = 10.dp, start = 120.dp)) {
                    Text(text = "Button")
                }

            }
        }
    }
}


