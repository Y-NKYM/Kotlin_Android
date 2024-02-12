package me.nkym.myfirstapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _count = mutableStateOf(0)

    //_count値を変更不可能値としてクラス外で取得可能にする。
    val count: MutableState<Int> = _count

    fun increment(){
        _count.value++
    }

    fun decrement(){
        _count.value--
    }
}