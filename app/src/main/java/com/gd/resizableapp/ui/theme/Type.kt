package com.gd.resizableapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Typography definitions for ResizableApp.
 *
 * Currently defines the default text styles used throughout the app.
 */
val Typography = Typography(
    /**
     * Style used for primary body text.
     *
     * - Font family: Default
     * - Font weight: Normal
     * - Font size: 16sp
     * - Line height: 24sp
     * - Letter spacing: 0.5sp
     */
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)