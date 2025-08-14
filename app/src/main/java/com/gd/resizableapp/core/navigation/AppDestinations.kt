package com.gd.resizableapp.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.gd.resizableapp.R

/**
 * Defines the main destinations of the application for navigation purposes.
 *
 * Each destination includes:
 * - A string resource ID for the label to display in the UI.
 * - An [ImageVector] icon representing the destination.
 * - A string resource ID for the content description to support accessibility.
 *
 * This enum is typically used in conjunction with the app's navigation host to
 * determine which screens are available and how they should be represented in
 * navigation UI components such as bottom bars or navigation drawers.
 */
enum class AppDestinations(
    @get:StringRes val label: Int,
    val icon: ImageVector,
    @get:StringRes val contentDescription: Int
) {
    /** Destination for the home screen, which displays the list of cryptocurrencies. */
    HOME(R.string.home, Icons.Default.Home, R.string.home),

    /** Destination for the settings screen, which allows the user to configure the app. */
    SETTINGS(R.string.settings, Icons.Default.Settings, R.string.settings),
}