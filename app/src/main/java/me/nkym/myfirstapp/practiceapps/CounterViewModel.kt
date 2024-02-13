package me.nkym.myfirstapp.practiceapps

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(): ViewModel() {

    private val _repository: CounterRepository = CounterRepository()
    //repository内のgetCounter関数内のデータクラスのcounter変数の値を取得。
    private val _count = mutableStateOf(_repository.getCounter().count)

    //_count値を変更不可能値としてクラス外で取得可能にする。
    val count: MutableState<Int> = _count

    fun increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}