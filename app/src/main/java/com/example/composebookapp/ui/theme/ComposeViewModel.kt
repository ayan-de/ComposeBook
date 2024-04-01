package com.example.composebookapp.ui.theme

import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.reflect.KProperty

class ComposeViewModel : ViewModel() {
    var selectedTabIndex by mutableStateOf(0)

    var darkMode by
    mutableStateOf(false)

    var buttonName by
    mutableStateOf("")

    var iconButton = mutableStateOf(false)

    fun toggleSwitch(){
        iconButton.value = !iconButton.value
    }
}

