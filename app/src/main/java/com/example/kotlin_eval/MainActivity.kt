package com.example.kotlin_eval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlin_eval.ui.Routes
import com.example.kotlin_eval.ui.screens.HomeScreen
import com.example.kotlin_eval.ui.screens.DetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Mon navController qui permet la navigation entre mes pages
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.HomeScreen) {

                composable(Routes.HomeScreen) {
                    HomeScreen(navController)
                }
                //Cette partie plus complexe car on passe en parametre un id pour afficher la card correspondante au character
                composable(
                    route = Routes.DetailsScreen,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val characterId = backStackEntry.arguments?.getString("id") // On récupère l'ID
                    DetailsScreen(navController, characterId) // On passe l'ID à DetailsScreen
                }
            }
        }
    }
}
