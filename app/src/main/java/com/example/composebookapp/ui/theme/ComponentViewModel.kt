package com.example.composebookapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ComponentViewModel : ViewModel() {
    var selectedTabIndex by mutableIntStateOf(0)

    var darkMode by
    mutableStateOf(false)

    var buttonName by
    mutableStateOf("")

    var iconButton = mutableStateOf(false)

}

