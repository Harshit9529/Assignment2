package com.example.assignment2.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Screen1(
    onTwoButtonClicked : () -> Unit,
    onThreeButtonClicked : () -> Unit
) {
    var list by rememberSaveable{ mutableStateOf(listOf<Int>()) }
    var count by rememberSaveable { mutableStateOf(0) }
    val sequence = listOf(1000 , -900 , 800 , -700 , 600 ,-500 , 400 , -300 , 200 ,-100 , 0 )

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(list.size){
                Text(text = list[it].toString() , modifier = Modifier.padding(top = 100.dp))
            }
        }
        NavigationBar(
            modifier = Modifier.padding(top = 50.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ) {
                Button(onClick = onTwoButtonClicked , modifier = Modifier.padding(top = 10.dp , start = 15.dp) ) {
                    Text(text = "2")
                }
                Button(onClick = onThreeButtonClicked , modifier = Modifier.padding(top = 10.dp , start = 15.dp) ) {
                    Text(text = "3")
                }
                Button(onClick = { if (count < sequence.size){
                    list = list + sequence[count]
                    count++
                }
                }, modifier = Modifier.padding(top = 10.dp , start = 120.dp))  {
                    Text(text = "Button")
                }

                }
            }
        }

    }





@Preview
@Composable
private fun Preview() {
    Column {
        Screen1(onTwoButtonClicked = {}, onThreeButtonClicked = {})
    }
}
