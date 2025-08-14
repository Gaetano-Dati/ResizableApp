package com.gd.resizableapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.gd.resizableapp.ui.components.AppScaffold
import com.gd.resizableapp.ui.theme.ResizableAppTheme

/**
 * The main entry point of the ResizableApp.
 *
 * This activity sets up the Compose UI and applies the app's theme.
 * It also initializes the [androidx.navigation.NavHostController] for navigation and
 * wraps the content in [AppScaffold] which manages the navigation suite.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enables edge-to-edge layout, drawing behind system bars
        enableEdgeToEdge()
        // Sets the content of the activity to a Compose UI hierarchy
        setContent {
            ResizableAppTheme {
                val navController = rememberNavController()
                AppScaffold(navController = navController)
            }
        }
    }
}