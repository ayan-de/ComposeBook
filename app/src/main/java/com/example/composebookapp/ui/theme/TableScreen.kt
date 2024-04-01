package com.example.composebookapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TableScreen(
    modifier: Modifier = Modifier,
    composeViewModel: ComposeViewModel = viewModel()
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(rowItemData.size) { i ->
            //rowItemData.forEach {
            if (rowItemData[i].rowName == "Name") {
                RowCell(
                    text = rowItemData[i].rowName,
                    value = composeViewModel.buttonName,
                    onValueChange = { composeViewModel.buttonName = it })
            } else if (rowItemData[i].rowName == "icon") {
                RowCell(
                    text = rowItemData[i].rowName,
                    icon = true,
                    checked = composeViewModel.iconButton.value,
                    onCheckedChange = { composeViewModel.iconButton.value = it })
            } else {
                RowCell(
                    text = rowItemData[i].rowName,
                    value = rowItemData[i].rowTextField,
                    onValueChange = {})
            }
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}
//}

@Composable
fun RowCell(
    text: String,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    icon: Boolean = false,
    checked: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    if (icon) {
        Row(
            modifier = Modifier,
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
            )
            Switch(
                modifier = Modifier
                    .padding(0.dp,0.dp,120.dp,0.dp),
                checked = checked, onCheckedChange = onCheckedChange
            )
        }
    } else {
        Row(
            modifier = Modifier,
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
            )
            TextField(value = value, onValueChange = onValueChange)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TableScreenPreview() {
    ComposeBookAppTheme {
        TableScreen()
    }
}
