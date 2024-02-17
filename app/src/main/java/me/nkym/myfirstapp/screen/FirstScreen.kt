package me.nkym.myfirstapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(navigationToSecondScreen: ()->Unit, navigationToFirstScreen: ()->Unit){
    val name = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the First Screen")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })
        Button(onClick = {
            //Transition from one screen to another.
            navigationToSecondScreen()
        }) {
            Text(text = "Go to Second Screen")
        }
        Button(onClick = {
            //Transition from one screen to another.
            navigationToFirstScreen()
        }) {
            Text(text = "Reload Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview(){
    //FirstScreen()  //本来遷移情報を送るが、ここでは送れないので実行できない。
}