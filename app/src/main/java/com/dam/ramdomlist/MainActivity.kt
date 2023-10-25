package com.dam.ramdomlist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.ramdomlist.ui.theme.RamdomListTheme

class MainActivity : ComponentActivity() {
    // Obtén una instancia del ViewModel
    private val viewModel: RandomNumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RamdomListTheme {
                // Pasa el ViewModel al composable
                RandomNumberUI(viewModel)
            }
        }
    }
}
@Composable
fun RandomNumberUI(viewModel: RandomNumberViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Marcador de ronda
        Text(
            text = "Ronda: ${viewModel.round.value}",
            style = MaterialTheme.typography.bodySmall,
            fontSize = if (viewModel.round.value > 10) 48.sp else 32.sp,
            color = if (viewModel.round.value > 10) Color.Red else Color.Black,
            modifier = Modifier.padding(16.dp)
        )



        // Cuatro círculos de colores
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            // Círculo azul
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue)
                    .clickable {
                        Log.d("SimonGame", "Botón azul presionado")
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Spacer(modifier = Modifier.height(16.dp))

            // Círculo verde
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .clickable {
                        Log.d("SimonGame", "Botón verde presionado")
                    }
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Círculo rojo
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
                    .clickable {
                        Log.d("SimonGame", "Botón rojo presionado")
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            // Círculo amarillo
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Yellow)
                    .clickable {
                        Log.d("SimonGame", "Botón amarillo presionado")
                    }
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Spacer(modifier = Modifier.height(64.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = {
                    viewModel.startGame()
                    Log.d("SimonGame", "Botón de start presionado")
                },
                modifier = Modifier
                    .size(100.dp) // Tamaño para hacerlo completamente redondo
                    .background(MaterialTheme.colorScheme.primary, CircleShape) // Usar CircleShape

            ) {
                Text(
                    "START",
                    modifier = Modifier
                        .widthIn(max = 100.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.startNextRound()
                    Log.d("SimonGame", "Botón de avanzar a la siguiente ronda presionado")
                },
                modifier = Modifier
                    .size(100.dp) // Tamaño para hacerlo completamente redondo
                    .background(MaterialTheme.colorScheme.primary, CircleShape) // Usar CircleShape
                    .padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}
