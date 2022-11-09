package com.example.cityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.cityapp.ui.CityApp
import com.example.cityapp.ui.theme.CityAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CityAppTheme {
                val windowSize = calculateWindowSizeClass(activity = this)
                CityApp(windowSize = windowSize.widthSizeClass)
            }
        }
    }
}


