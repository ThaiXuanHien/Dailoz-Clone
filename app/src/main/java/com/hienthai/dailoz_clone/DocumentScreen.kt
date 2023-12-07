package com.hienthai.dailoz_clone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.calendar.CalendarApp
import com.hienthai.dailoz_clone.screens.base.BaseSearch
import com.hienthai.dailoz_clone.screens.base.ItemCategoryTask

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DocumentScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .background(Color.White.copy(0.8f))
            ) {
                BaseSearch()
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (Modifier.verticalScroll(rememberScrollState())){
                CalendarApp()
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Today",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.color_text_content_splash)
                )
                Spacer(modifier = Modifier.height(20.dp))
                repeat((0..20).count()) {
                    ItemCategoryTask()
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
const val DOCUMENT_ROUTE = "document_route"