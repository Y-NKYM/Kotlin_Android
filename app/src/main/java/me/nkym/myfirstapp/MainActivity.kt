package me.nkym.myfirstapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.nkym.myfirstapp.ui.theme.MyFirstAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //UnitConverter()
                    CaptainGame()
                }
            }
        }
    }
    @Composable
    fun CaptainGame(){
        var test1 = 0
        var test3 = 3
        var test2 = remember{ test3 }
        val treasuresFound = remember { mutableIntStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        Column{
            Text(text = "no remember: ${test1}")
            Text(text = "no mutableStateOf: ${test2}")
            Text(text = "remember + mutableStateOf: ${treasuresFound.value}")
            Text(text = "Current Direction: ${direction.value}")
            //East
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    test1 += 1
                    test3 += 1
                }
            }){
                Text(text = "Sail East")
            }

            //South
            Button(onClick = {
                direction.value = "South"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                }
            }){
                Text(text = "Sail South")
            }

            //North
            Button(onClick = {
                direction.value = "North"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                }
            }){
                Text(text = "Sail North")
            }

            //West
            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                }
            }){
                Text(text = "Sail West")
            }

        }
    }
}

@Composable
fun UnitConverter(){
    //Column{}内に記述する要素は重ならず、一行下に記述される。
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", modifier = Modifier.padding())
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = {
            //Value値が変化した際に実行されるソースコードを記述する。
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            /*
            val context = LocalContext.current
            Button(onClick = {
                //Toast(PopUp) when clicking button
                Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
            }){
                Text(text = "Click Me")
            }
            */

            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")

                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }){
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Inches") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }){
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(
                        text = { Text("Inches") },
                        onClick = { /*TODO*/ }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result:")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "$name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
/* Virtual Deviceを使用することなく、Preview機能で表示する際のコード */
fun UnitConverterPreview() {
    UnitConverter()
}