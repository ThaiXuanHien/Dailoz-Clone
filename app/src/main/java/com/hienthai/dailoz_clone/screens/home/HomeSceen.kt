package com.hienthai.dailoz_clone.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hienthai.dailoz_clone.DOCUMENT_ROUTE
import com.hienthai.dailoz_clone.NavGraph
import com.hienthai.dailoz_clone.R
import com.hienthai.dailoz_clone.screens.ADD_TASK_ROUTE
import com.hienthai.dailoz_clone.screens.base.ItemTask
import com.hienthai.dailoz_clone.screens.base.TwoByTwoColumn

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onClickCompleted: () -> Unit,
    onClickPending: () -> Unit,
    onClickCanceled: () -> Unit,
    onClickOnGoing: () -> Unit
) {

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
            item {
                TwoByTwoColumn(
                    onClickCompleted = {
                        onClickCompleted()
                    },
                    onClickPending = {
                        onClickPending()
                    },
                    onClickCanceled = {
                        onClickCanceled()
                    },
                    onClickOnGoing = {
                        onClickOnGoing()
                    }
                )
            }
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

                if (it == 19) {
                    Box (modifier = Modifier.padding(bottom = 80.dp)){
                        ItemTask(
                            title = "Cleaning Clothes $it",
                            colorItem = R.color.color_bg_item_task,
                            R.color.color_tag_office
                        )
                    }

                } else {
                    ItemTask(
                        title = "Cleaning Clothes $it",
                        colorItem = R.color.color_bg_item_task,
                        R.color.color_tag_office
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen({}, {}, {}, {})
}

@Composable
fun TopHomeScreen() {
    Box(modifier = Modifier.background(Color.White.copy(0.8f))) {
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



const val HOME_ROUTE = "home_route"