package com.gd.resizableapp.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gd.resizableapp.core.navigation.AppDestinations
import com.gd.resizableapp.core.navigation.AppNavHost
import com.gd.resizableapp.core.navigation.navigationSuiteItem

/**
 * Sets up the main scaffold of the application with a navigation suite.
 *
 * This composable handles the overall layout structure including:
 * - Bottom/side navigation via [NavigationSuiteScaffold].
 * - Highlighting the currently selected destination.
 * - Navigation between [AppDestinations] using [NavHostController].
 *
 * @param navController The [NavHostController] responsible for navigation
 * between composable destinations.
 */
@Composable
fun AppScaffold(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val destinations = listOf(AppDestinations.HOME, AppDestinations.SETTINGS)

    val colors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            destinations.forEach { destination ->
                navigationSuiteItem(
                    destination = destination,
                    isSelected = currentRoute == destination.name,
                    colors = colors,
                    onClick = {
                        navController.navigate(destination.name) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = Color.Transparent
        )
    ) {
        AppNavHost(navController = navController)
    }
}