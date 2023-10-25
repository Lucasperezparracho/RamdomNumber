package com.dam.ramdomlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class RandomNumberViewModel : ViewModel() {
    // Estado del texto y número aleatorio
    var text by mutableStateOf("")
    var randomNumber by mutableStateOf(0)
    val numberList = mutableListOf<Int>()
    var round = mutableStateOf(1)

    // Función para generar un número aleatorio
    fun generateRandomNumber() {
        val max = text.toIntOrNull() ?: 10
        randomNumber = Random.nextInt(max + 1)
    }
    fun addRandomNumber() {
        val randomNumber = (1..4).random()
        numberList.add(randomNumber)
    }
    fun startGame() {
        numberList.clear()
        round.value = 1
    }

    fun startNextRound() {
        round.value++
    }
}
