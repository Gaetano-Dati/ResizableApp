package com.gd.resizableapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gd.resizableapp.featurehome.ListScaffold
import com.gd.resizableapp.featuresettings.SettingsScreen

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