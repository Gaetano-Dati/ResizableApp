package com.gd.resizableapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.gd.resizableapp.ui.components.AppScaffold
import com.gd.resizableapp.ui.theme.ResizableAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResizableAppTheme {
                val navController = rememberNavController()
                AppScaffold(navController = navController)
            }
        }
    }
}