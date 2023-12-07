package com.hienthai.dailoz_clone.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hienthai.dailoz_clone.screens.base.BaseSearch
import com.hienthai.dailoz_clone.screens.base.FilterView
import com.hienthai.dailoz_clone.screens.base.ItemCategoryTask
import com.hienthai.dailoz_clone.screens.base.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CompletedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            stickyHeader {
                TopBar(title = "Completed")
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        BaseSearch()
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    FilterView()

                }
            }
            items(20) {
                ItemCategoryTask()
            }
        }
    }
}

@Preview
@Composable
fun CompletedScreenPreview() {
    CompletedScreen()
}

const val COMPLETE_ROUTE = "complete_route"