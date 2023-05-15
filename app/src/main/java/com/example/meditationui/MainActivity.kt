package com.example.meditationui

import android.R
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditationui.ui.DetailScreen
import com.example.meditationui.ui.HomeScreen
import com.example.meditationui.ui.theme.MeditationUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            MeditationUITheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen() }
                    composable("detail") { DetailScreen(/*...*/) }
                    /*...*/
                }
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )


    }
}
