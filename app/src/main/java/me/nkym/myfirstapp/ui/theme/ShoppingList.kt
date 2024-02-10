package me.nkym.myfirstapp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val id:Int,
    var name: String,
    var quantity:Int,
    var isEditing:Boolean = false
)

@Composable
fun ShoppingListApp(){
    //アイテムリスト
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    //ポップアップ表示有無
    var showDialog by remember { mutableStateOf(false) }

    //記述内容保管用変数
    var itemName by remember{ mutableStateOf("") }
    var itemQuantity by remember{ mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Add Item")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(sItems) {
                item ->
                if(item.isEditing){
                    ShoppingItemEditor(item = item, onEditComplete = {
                        editedName, editedQuantity ->
                        //配列に存在するクラス全てのisEditingをfalseにし、どれも編集状態ではないようにする。
                        sItems = sItems.map { it.copy(isEditing = false) }
                        //.find{}は配列をループさせ、一番最初に引っかかった要素を戻り値とする。
                        //ループして一つ一つの要素をitとし、編集していたクラス(item)のidと比較してマッチしたものをeditedItemとする。
                        val editedItem = sItems.find { it.id == item.id }//つまりは{ it -> it.id == item.id }と同じ。
                        //findでマッチがない場合nullとなってしまうので"?"でエラーとならないようにする。
                        editedItem?.let{
                            //編集内容をクラス内のメンバ変数に更新
                            it.name = editedName
                            it.quantity = editedQuantity
                        }
                    })
                } else {
                    ShoppingListItem(item = item,
                        //編集ボタンがクリックされた場合
                        onEditClick = {
                            /*
                            ボタンがクリックされると、ループ中の子の要素反映時にonEditClickのコード内容が実行される。
                            よってitemはそのクリックされた要素を指し、itはmapでのループによるもの。
                            クリックされたクラスを見つけ出し、そのクラスのisEditingをtrue更新した配列をコピー。
                            元の配列に上書きする。
                            */
                            sItems = sItems.map { it.copy(isEditing = it.id == item.id ) }
                    }) {
                        
                    }
                }
            }
        }
    }

    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Button(onClick = {
                                    if(itemName.isNotBlank()){
                                        val newItem = ShoppingItem(
                                            id = sItems.size+1,
                                            name = itemName,
                                            quantity = itemQuantity.toInt()
                                        )
                                        sItems = sItems + newItem
                                        showDialog = false
                                        itemName = ""
                                        itemQuantity = ""
                                    }
                                }) {
                                    Text(text = "Add")
                                }
                                Button(onClick = {
                                    showDialog = false
                                }) {
                                    Text(text = "Cancel")
                                }
                            }
                            },
            title = { Text("Add Shopping Item") },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = { itemQuantity = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        )
    }
}

//アイテム一つ一つのレイアウト設定用関数
@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEditClick : () -> Unit,
    onDeleteClick: () -> Unit
){
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color(0xFF000000)),
                shape = RoundedCornerShape(20)
            )
    ){
        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "Qty: ${item.quantity}", modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.padding(8.dp)){
            IconButton(onClick = onEditClick){
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton(onClick = onDeleteClick){
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}

@Composable
fun ShoppingItemEditor(
    item: ShoppingItem,
    //{}内のコードが実行し終えた後にすべきこと
    onEditComplete: (String, Int) -> Unit)
{
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember{ mutableStateOf(item.isEditing) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column{
            BasicTextField(
                value = editedName,
                onValueChange = {editedName = it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
                )
            BasicTextField(
                value = editedQuantity,
                onValueChange = {editedQuantity = it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            Button(onClick = {
                isEditing = false
                onEditComplete(editedName, editedQuantity.toIntOrNull()?: 1)
            }) {
                Text(text = "Save")
            }
        }
    }
}