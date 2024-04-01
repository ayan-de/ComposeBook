package com.example.composebookapp.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

@Composable
fun ComposableList(
    onClick:() ->Unit,
    shape: Shape = RectangleShape,
    color: ButtonColors = ButtonDefaults.buttonColors(Color.Red),
    modifier: Modifier = Modifier,
    text:String = "Primary",
    icon: Boolean = true
){
    Button(
        onClick = onClick,
        shape = shape,
        colors = color,
        modifier = modifier,
        ) {
        if (icon){
            Icon(imageVector = Icons.Rounded.Star, contentDescription = "Button Icon")
        }
        Text(text = text, color = Color.White)
    }
}