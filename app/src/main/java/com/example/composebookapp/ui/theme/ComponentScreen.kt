package com.example.composebookapp.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComponentScreen(
    composeViewModel: ComponentViewModel = viewModel()
) {
    val pagerState = rememberPagerState {
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
                    Component(
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
fun Component(text: String = "Primary", icon:Boolean) {
    //Text(text = "Here Comes the composable ")
    ComponentList(
        onClick = {},
        color = ButtonDefaults.buttonColors(Color.Blue),
        shape = CutCornerShape(10),
        text = text,
        icon = icon
    )
}


@Preview(showBackground = true)
@Composable
fun ComponentScreenPreview() {
    ComposeBookAppTheme {
        ComponentScreen()
    }
}
