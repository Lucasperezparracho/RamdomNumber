package com.dam.ramdomlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

data class RandomNumberData(
    val randomNumber: Int,
    val numberList: List<Int>
)

class RandomNumberViewModel : ViewModel() {
    var text by mutableStateOf("")
    var data by mutableStateOf(RandomNumberData(0, emptyList()))

    fun generateRandomNumber() {
        val max = text.toIntOrNull() ?: 10
        val newRandomNumber = Random.nextInt(max + 1)
        val newNumberList = data.numberList.toMutableList()
        newNumberList.add((1..4).random())
        data = RandomNumberData(newRandomNumber, newNumberList)
    }
}