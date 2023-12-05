package com.hienthai.dailoz_clone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hienthai.dailoz_clone.screens.base.BaseSearch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DocumentScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            stickyHeader {
                Box(modifier = Modifier
                    .background(Color.White.copy(0.8f))
                    .padding(24.dp)) {
                    BaseSearch()
                }
            }
        }
    }
}

@Preview
@Composable
fun DocumentScreenPreview() {
    DocumentScreen()
}