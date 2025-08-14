package com.gd.resizableapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gd.resizableapp.featurehome.ListScaffold
import com.gd.resizableapp.featuresettings.SettingsScreen

/**
 * Sets up the main navigation graph for the application.
 *
 * This composable defines the available navigation destinations and their
 * associated screens using the [NavHost] API. It controls the navigation flow
 * by linking each [AppDestinations] entry to its respective composable screen.
 *
 * Destinations:
 * - [AppDestinations.HOME] → Displays [ListScaffold], which shows the list of cryptocurrencies.
 * - [AppDestinations.SETTINGS] → Displays [SettingsScreen], which allows the user to configure the app.
 *
 * @param navController The [NavHostController] responsible for managing navigation state.
 */
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.HOME.name
    ) {
        composable(AppDestinations.HOME.name) { ListScaffold() }
        composable(AppDestinations.SETTINGS.name) { SettingsScreen() }
    }
}