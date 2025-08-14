package com.gd.resizableapp.featuresettings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.gd.resizableapp.R

/**
 * Displays the Settings screen for the application.
 *
 * Currently a placeholder showing a centered text. Can be extended to include
 * user preferences, app configurations, or other settings in the future.
 *
 * @param modifier A [Modifier] for styling and layout adjustments.
 */
@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.settings))
    }
}