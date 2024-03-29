package me.nkym.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.nkym.myfirstapp.practiceapps.CounterApp
import me.nkym.myfirstapp.practiceapps.CounterViewModel
import me.nkym.myfirstapp.screen.FirstScreen
import me.nkym.myfirstapp.screen.SecondScreen
import me.nkym.myfirstapp.screen.ThirdScreen
import me.nkym.myfirstapp.ui.theme.MyFirstAppTheme
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()

                    //RecipeScreen()
                    //val viewModel: CounterViewModel = viewModel()
                    //CounterApp(viewModel)
                    //Text(text = "Treasure")
                    //ShoppingListApp()
                    //UnitConverter()
                    //CaptainGame()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "firstScreen"  //Different from class name.
    ){
        composable("firstScreen"){
            //クラス内のメンバ変数を取得し、URL越しに送る記述
            FirstScreen(){name, age ->
                navController.navigate("secondScreen/$name/$age")
            }
        }
        //URLで取得したメンバ変数を別のクラスへ送るための記述
        composable("secondScreen/{name}/{age}"){
            //URLからの値を変数に代入
            val name = it.arguments?.getString("name") ?: "no name"
            val age = it.arguments?.getString("age") ?: "0"
            //クラスのパラメーターに当てはめる
            SecondScreen(name = name, age = age,
                navigationToFirstScreen = { navController.navigate("firstScreen") }
            ) { navController.navigate("thirdScreen") }
//            SecondScreen(name){
//                navController.navigate("firstScreen")
//            }
        }
        composable("thirdScreen"){
            ThirdScreen(){
                navController.navigate("firstScreen")
            }
        }
    }
}

/*
@Composable
fun CaptainGame(){
    val stormOrTreasure = remember{ mutableStateOf("") }
    //val treasuresFound = remember { mutableIntStateOf(0) }
    var treasuresFound by remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    Column{
        Text(text = "Treasure Found: ${treasuresFound}")
        Text(text = "Current Direction: ${direction.value}")
        Text(text = stormOrTreasure.value)
        //East
        Button(onClick = {
            direction.value = "East"
            if(Random.nextBoolean()){
                treasuresFound += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }

        }){
            Text(text = "Sail East")
        }

        //South
        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()){
                //treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }){
            Text(text = "Sail South")
        }

        //North
        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()){
                //treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }){
            Text(text = "Sail North")
        }

        //West
        Button(onClick = {
            direction.value = "West"
            if(Random.nextBoolean()){
                //treasuresFound.value += 1
                stormOrTreasure.value = "Found a Treasure!"
            } else {
                stormOrTreasure.value = "Storm Ahead!"
            }
        }){
            Text(text = "Sail West")
        }

    }
}

@Composable
fun UnitConverter(){
    var inputValue by remember{ mutableStateOf("") }
    var outputValue by remember{ mutableStateOf("") }
    var inputUnit by remember{ mutableStateOf("Meters") }
    var outputUnit by remember{ mutableStateOf("Meters") }
    var iExpanded by remember{ mutableStateOf(false) }
    var oExpanded by remember{ mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull()?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt()/100.0
        outputValue = result.toString()
    }

    //Column{}内に記述する要素は重ならず、一行下に記述される。
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", 
            modifier = Modifier.padding(),
            style = MaterialTheme.typography.headlineLarge
            )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                //Value値が変化した際に実行されるソースコードを記述する。
                inputValue = it
                convertUnits()
            },
            label = { Text(text = "Enter Value")}
        )
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
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")

                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }){
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"
                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }){
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Millimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        //方法1
        Text("Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily.Cursive
        )
        //方法２
        val customTextStyle = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 32.sp,
            color = Color.Red
        )
        Text("Result: $outputValue $outputUnit",
            style = customTextStyle
        )
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

*/