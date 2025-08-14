package com.gd.resizableapp.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.ui.res.stringResource
import com.gd.resizableapp.core.navigation.AppDestinations

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