package com.example.composebookapp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composebookapp.data.tabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeScreen(
    composeViewModel: ComposeViewModel = viewModel()
) {
    var pagerState = rememberPagerState {
        tabItemData.size
    }

    LaunchedEffect(composeViewModel.selectedTabIndex) {
        pagerState.animateScrollToPage(composeViewModel.selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            composeViewModel.selectedTabIndex = pagerState.currentPage
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        ComposeBookAppTheme(darkTheme = composeViewModel.darkMode) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.background
            ) {
                Switch(checked = composeViewModel.darkMode, onCheckedChange = { composeViewModel.darkMode = !composeViewModel.darkMode })
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Composables(
                        modifier = Modifier,
                        text = composeViewModel.buttonName,
                        icon = composeViewModel.iconButton.value
                    )
                }
            }
        }
        ScrollableTabRow(
            modifier = Modifier,
            selectedTabIndex = composeViewModel.selectedTabIndex
        ) {
            tabItemData.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == composeViewModel.selectedTabIndex,
                    onClick = { composeViewModel.selectedTabIndex = index },
                    text = {
                        Text(text = tabItem.title)
                    },
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                //contentAlignment = Alignment.Center
            ) {
                //Text(text = tabItemData[index].title)
                when (composeViewModel.selectedTabIndex) {
                    0 -> TableScreen(
//                        name = composeViewModel.buttonName,
                    )
                    1 -> Text(text = tabItemData[index].title)
                    2 -> Text(text = tabItemData[index].title)
                }
            }
        }
    }
}
//}

@Composable
fun Composables(modifier: Modifier, text: String, icon:Boolean) {
    //Text(text = "Here Comes the composable ")
    ComposableList(
        onClick = {},
        color = ButtonDefaults.buttonColors(Color.Blue),
        shape = CutCornerShape(10),
        text = text,
        icon = icon
    )
}


@Preview(showBackground = true)
@Composable
fun ComposeScreenPreview() {
    ComposeBookAppTheme {
        ComposeScreen()
    }
}
