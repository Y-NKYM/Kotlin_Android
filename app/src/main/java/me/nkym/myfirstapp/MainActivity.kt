package me.nkym.myfirstapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import me.nkym.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    //Column{}内に記述する要素は重ならず、一行下に記述される。
    Column {
//        TextField(value = "", onValueChange = {})
        OutlinedTextField(value = "", onValueChange = {
            //Value値が変化した際に実行されるソースコードを記述する。
        })
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
            }
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
        }
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