package com.example.kotlin_eval.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin_eval.domain.models.Character
import com.example.kotlin_eval.ui.viewmodels.CharacterViewModel
import com.example.kotlin_eval.components.BtnReturn
import com.example.kotlin_eval.ui.Routes

@Composable
fun DetailsScreen(navController: NavController, characterId: String?) {
    val viewModel: CharacterViewModel = viewModel()
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    val selectedCharacter = characters.find { it.uuid == characterId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //  Bouton de retour en haut à gauche
        BtnReturn(
            onClick = { navController.navigate(Routes.HomeScreen) },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 16.dp)
        )

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (errorMessage != null) {
            Text(
                text = errorMessage ?: "",
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            if (selectedCharacter != null) {
                CharacterItemDetails(character = selectedCharacter)
            } else {
                Text(
                    text = "Personnage introuvable.",
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
        }
    }
}

//Declare l'objet character pour appeler son model
@Composable
fun CharacterItemDetails(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), // Marge externe autour de la carte
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Élévation de la carte
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Padding interne de la carte
        ) {
            Text(
                text = "Nom: ${character.displayName}",
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Rôle: ${character.role}",
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Description: ${character.description}",
                color = Color.Gray
            )
        }
    }
}
