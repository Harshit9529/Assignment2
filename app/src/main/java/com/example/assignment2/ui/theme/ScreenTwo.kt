package com.example.assignment2.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.rememberNavController

@Composable
fun Screen2(
    onOneButtonClicked : () -> Unit,
    onThreeButtonClicked : () -> Unit
) {
    var list by rememberSaveable { mutableStateOf(listOf<Int>()) }
    var count by rememberSaveable { mutableStateOf(0) }
    val sequence = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(modifier = Modifier.weight(1f) ,
            horizontalArrangement = Arrangement.SpaceBetween) {
            items(list.size) {
                Text(text = list[it].toString(),
                    modifier = Modifier.padding(top = 350.dp , start = 20.dp, end = 20.dp),
                    fontSize = 25.sp)
            }
        }
        NavigationBar(
            modifier = Modifier.padding(top = 50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ) {
                Button(onClick = onOneButtonClicked,
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp)) {
                    Text(text = "1")
                }
                Button(onClick = onThreeButtonClicked,
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp)) {
                    Text(text = "3")
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

@Preview
@Composable
private fun Preview() {
    Screen2(onOneButtonClicked = {}, onThreeButtonClicked = {})
}
