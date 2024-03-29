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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
//別のクラスへ送る変数のデータ型をパラメーターとして記述
fun FirstScreen(navigationToSecondScreen:(String, String)->Unit){
    //保持するための変数の用意
    val name = remember {
        mutableStateOf("")
    }
    val age = remember {
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
        //用意した変数に値を代入
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })
        OutlinedTextField(value = age.value, onValueChange = {
            age.value = it
        })
        Button(onClick = {
            //Transition from one screen to another.
            //遷移画面先をルート名で指定。（）内にURLに必要な変数を送る。
            navigationToSecondScreen(name.value, age.value)
        }) {
            Text(text = "Go to Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview(){
    //FirstScreen()  //本来遷移情報を送るが、ここでは送れないので実行できない。
}