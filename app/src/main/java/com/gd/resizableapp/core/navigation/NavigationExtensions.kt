package com.gd.resizableapp.core.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.ui.res.stringResource

/**
 * Adds a navigation item to a [NavigationSuiteScope] for a given [AppDestinations].
 *
 * This helper function simplifies creating a navigation item with:
 * - An icon and label based on the [destination].
 * - Custom colors via [colors].
 * - Selection state via [isSelected].
 * - Click handling via [onClick].
 *
 * @param destination The [AppDestinations] enum representing the target screen.
 * @param colors The [NavigationSuiteItemColors] used to style the item.
 * @param isSelected True if this item represents the currently selected destination.
 * @param onClick Lambda executed when the item is clicked.
 */
fun NavigationSuiteScope.navigationSuiteItem(
    destination: AppDestinations,
    colors: NavigationSuiteItemColors,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    item(
        icon = {
            Icon(
                imageVector = destination.icon,
                contentDescription = stringResource(destination.contentDescription)
            )
        },
        label = { Text(stringResource(destination.label)) },
        selected = isSelected,
        colors = colors,
        onClick = onClick
    )
}