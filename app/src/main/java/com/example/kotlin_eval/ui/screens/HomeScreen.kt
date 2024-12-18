package com.example.kotlin_eval.ui.screens

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin_eval.domain.models.Character
import com.example.kotlin_eval.ui.viewmodels.CharacterViewModel
import androidx.compose.ui.platform.LocalContext
import com.example.kotlin_eval.R

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: CharacterViewModel = viewModel()
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.click) }
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    // Fonction du son
    fun playClickSound() {
        mediaPlayer.start()
    }

    // Fonction de la vibration
    fun vibrate() {
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(200)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (errorMessage != null) {
            Text(
                text = errorMessage ?: "",
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(characters) { character ->
                    CharacterItemHome(
                        character = character,
                        onClick = {
                            //Censé jouer un son au click d'une card (fonctionne pas)
                            playClickSound()
                            vibrate()
                            // Récuperation de l'id pour le passer en paramètre dans detailscreen
                            val idCharacter = character.uuid
                            navController.navigate("details/$idCharacter")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CharacterItemHome(character: Character, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEEEEEE)
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Nom: ${character.displayName}",
                color = Color.Black
            )
            Text(
                text = "Rôle: ${character.role}",
                color = Color.Gray
            )
        }
    }
}
