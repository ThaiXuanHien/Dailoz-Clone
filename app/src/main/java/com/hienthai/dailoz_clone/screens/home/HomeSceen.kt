package com.hienthai.dailoz_clone.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.R
import com.hienthai.dailoz_clone.screens.base.ItemTask
import com.hienthai.dailoz_clone.screens.base.ListCategory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
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
                TopHomeScreen()
            }
            item {
                Text(
                    text = "My Task",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.color_text_content_splash)
                )
            }
//            item {
//                ListCategory()
//            }
            item {
                Row() {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Today Task",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.color_text_content_splash)
                    )
                    Text(
                        text = "View all",
                        color = colorResource(id = R.color.color_view_all),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            items(20) {
                ItemTask(
                    title = "Cleaning Clothes $it",
                    colorItem = R.color.color_bg_item_task,
                    R.color.color_tag_office)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun TopHomeScreen() {
    Box (modifier = Modifier.background(Color.White.copy(0.8f))){
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hi, Steven",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.color_text_item_category)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Let’s make this day productive",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.color_intro_user)
                )
            }
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 1.dp,
                        spotColor = colorResource(id = R.color.base_color),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(Color.White)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_avatar),
                    contentDescription = "avatar"
                )
            }
        }
    }
}

@Preview
@Composable
fun TopHomeScreenPreview() {
    TopHomeScreen()
}

private fun Modifier.bottomElevation(): Modifier = this.then(Modifier.drawWithContent {
    val paddingPx = 8.dp.toPx()
    clipRect(
        left = 0f,
        top = 0f,
        right = size.width,
        bottom = size.height + paddingPx
    ) {
        this@drawWithContent.drawContent()
    }
})