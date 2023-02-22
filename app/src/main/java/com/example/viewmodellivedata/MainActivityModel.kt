package com.example.viewmodellivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel() {
//    var count = 0
    var count = MutableLiveData<Int>()
    init {
        count.value = 0
    }
    fun increase() {
//        count++
        count.value = (count.value)?.plus(1)
    }
    fun decrease() {
//        count--
        count.value = (count.value)?.minus(1)
    }
    fun resetCount() {
//        count--
        count.value = 0
    }
}