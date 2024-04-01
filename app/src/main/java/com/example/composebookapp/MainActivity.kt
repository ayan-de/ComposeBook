package com.example.composebookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.composebookapp.ui.theme.ComponentScreen
import com.example.composebookapp.ui.theme.ComposeBookAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val darkMode by mutableStateOf(true)

        setContent {
            ComposeBookAppTheme(darkTheme = darkMode) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Switch(checked = darkMode, onCheckedChange = {darkMode = !darkMode})
                    ComponentScreen()
                }
            }
        }
    }
}