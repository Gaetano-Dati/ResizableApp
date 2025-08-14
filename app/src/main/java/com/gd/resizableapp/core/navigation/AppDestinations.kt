package com.gd.resizableapp.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.gd.resizableapp.R

/**
 * AppDestinations defines the top-level navigation items for the app.
 *
 * @property label The string resource ID for the label text.
 * @property icon The icon representing the destination.
 * @property contentDescription The string resource ID for accessibility descriptions.
 */
enum class AppDestinations(
    @get:StringRes val label: Int,
    val icon: ImageVector,
    @get:StringRes val contentDescription: Int
) {
    /** Displays the list of cryptocurrencies. */
    HOME(R.string.home, Icons.Default.Home, R.string.home),

    /** Displays app settings. */
    SETTINGS(R.string.settings, Icons.Default.Settings, R.string.settings),
}