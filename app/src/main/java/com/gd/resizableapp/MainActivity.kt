package com.gd.resizableapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gd.resizableapp.core.navigation.AppDestinations
import com.gd.resizableapp.core.utils.getMockCryptos
import com.gd.resizableapp.ui.theme.ResizableAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3AdaptiveApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResizableAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                // Define a list of destinations for the navigation suite.
                val destinations = listOf(AppDestinations.HOME, AppDestinations.SETTINGS)

                val myNavigationSuiteItemColors = NavigationSuiteDefaults.itemColors(
                    navigationBarItemColors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )

                NavigationSuiteScaffold(
                    navigationSuiteItems = {
                        destinations.forEach { destination ->
                            item(
                                icon = {
                                    Icon(
                                        imageVector = destination.icon,
                                        contentDescription = stringResource(destination.contentDescription)
                                    )
                                },
                                label = { Text(text = stringResource(destination.label)) },
                                selected = currentRoute == destination.name,
                                colors = myNavigationSuiteItemColors,
                                onClick = {
                                    navController.navigate(destination.name) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
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
                    NavHost(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        startDestination = AppDestinations.HOME.name,
                    ) {
                        composable(route = AppDestinations.HOME.name) {
                            ListScaffold(modifier = Modifier.fillMaxSize())
                        }
                        composable(route = AppDestinations.SETTINGS.name) { SettingsDestination() }
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsDestination(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Settings")
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ListScaffold(
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listDetailNavigator = rememberListDetailPaneScaffoldNavigator<Crypto?>()
    BackHandler(listDetailNavigator.canNavigateBack()) {
        scope.launch { listDetailNavigator.navigateBack() }
    }
    ListDetailPaneScaffold(
        modifier = modifier,
        directive = listDetailNavigator.scaffoldDirective,
        scaffoldState = listDetailNavigator.scaffoldState,
        listPane = {
            MainPane(
                cryptos = getMockCryptos(),
                onCryptoSelected = {
                    scope.launch {
                        listDetailNavigator.navigateTo(
                            ListDetailPaneScaffoldRole.Detail,
                            contentKey = it
                        )
                    }
                }
            )
        },
        detailPane = {
            val selectedCrypto = listDetailNavigator.currentDestination?.contentKey
            SupportingPane(
                crypto = selectedCrypto,
                onBack = {
                    scope.launch {
                        listDetailNavigator.navigateBack()
                    }
                }
            )
        }
    )
}