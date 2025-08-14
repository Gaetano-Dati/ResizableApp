package com.gd.resizableapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Dark color scheme used in ResizableApp when the system or app theme is dark.
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

/**
 * Light color scheme used in ResizableApp when the system or app theme is light.
 */
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

/**
 * Composable that applies the ResizableApp Material3 theme to its content.
 *
 * The theme automatically switches between light and dark color schemes depending
 * on the system setting or the `darkTheme` parameter.
 *
 * @param darkTheme If true, applies dark color scheme; if false, applies light color scheme.
 *                  Defaults to system setting via [isSystemInDarkTheme].
 * @param dynamicColor If true, uses dynamic color available on Android 12+ based on wallpaper.
 *                     Defaults to true.
 * @param content The composable content that will be styled with this theme.
 */
@Composable
fun ResizableAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}