package com.hienthai.dailoz_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hienthai.dailoz_clone.screens.ADD_TASK_ROUTE
import com.hienthai.dailoz_clone.screens.AddTagScreen
import com.hienthai.dailoz_clone.screens.CANCELED_ROUTE
import com.hienthai.dailoz_clone.screens.COMPLETE_ROUTE
import com.hienthai.dailoz_clone.screens.CanceledScreen
import com.hienthai.dailoz_clone.screens.CompletedScreen
import com.hienthai.dailoz_clone.screens.ONGOING_ROUTE
import com.hienthai.dailoz_clone.screens.OnGoingScreen
import com.hienthai.dailoz_clone.screens.PENDING_ROUTE
import com.hienthai.dailoz_clone.screens.PendingScreen
import com.hienthai.dailoz_clone.screens.home.HOME_ROUTE
import com.hienthai.dailoz_clone.screens.home.HomeScreen
import com.hienthai.dailoz_clone.ui.theme.DailozCloneTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailozCloneTheme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    val navController = rememberNavController()
    // A surface container using the 'background' color from the theme
    Scaffold (bottomBar = {
        Box(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            BottomBar(
                navController = navController,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

    }){
        it.calculateBottomPadding()
        NavGraph(navController = navController)
    }


}

@Preview
@Composable
fun MainAppPreview() {
    MainApp()
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {

        composable(HOME_ROUTE) {
            HomeScreen(
                onClickCompleted = {
                    navController.navigate(COMPLETE_ROUTE)
                },
                onClickPending = {
                    navController.navigate(PENDING_ROUTE)
                },
                onClickCanceled = {
                    navController.navigate(CANCELED_ROUTE)
                },
                onClickOnGoing = {
                    navController.navigate(ONGOING_ROUTE)
                }
            )
        }

        composable(COMPLETE_ROUTE) {
            CompletedScreen()
        }

        composable(PENDING_ROUTE) {
            PendingScreen()
        }

        composable(CANCELED_ROUTE) {
            CanceledScreen()
        }

        composable(ONGOING_ROUTE) {
            OnGoingScreen()
        }

        composable(DOCUMENT_ROUTE) {
            DocumentScreen()
        }

        composable(ADD_TASK_ROUTE) {
            AddTagScreen()
        }

    }
}


@Composable
fun BottomBar(modifier: Modifier, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: HOME_ROUTE
    Row(
        modifier = modifier
            .navigationBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(14.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(14.dp)
                )

        ) {
            Box(modifier = Modifier.weight(1f)) {
                MainBottomNavItem(
                    iconEnable = R.drawable.ic_home,
                    iconDisable = R.drawable.ic_home_disable,
                    isSelected = currentRoute == HOME_ROUTE
                ) {
                    navController.switchTab(HOME_ROUTE)
                }
            }

            Box(modifier = Modifier.weight(1f)) {
                MainBottomNavItem(
                    iconEnable = R.drawable.ic_document,
                    iconDisable = R.drawable.ic_document_disable,
                    isSelected = currentRoute == DOCUMENT_ROUTE
                ) {
                    navController.switchTab(DOCUMENT_ROUTE)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        onClick = {
                            navController.switchTab(ADD_TASK_ROUTE)
                        }
                    )
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                MainBottomNavItem(
                    iconEnable = R.drawable.ic_activity_disable,
                    iconDisable = R.drawable.ic_activity_disable,
                    isSelected = currentRoute == DOCUMENT_ROUTE
                ) {
                    navController.switchTab(DOCUMENT_ROUTE)
                }
            }

            Box(modifier = Modifier.weight(1f)) {
                MainBottomNavItem(
                    iconEnable = R.drawable.ic_folder_tab,
                    iconDisable = R.drawable.ic_folder_tab,
                    isSelected = currentRoute == DOCUMENT_ROUTE
                ) {
                    navController.switchTab(DOCUMENT_ROUTE)
                }
            }
        }
    }
}

@Composable
fun MainBottomNavItem(
    iconEnable: Int,
    iconDisable: Int,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onItemClick() }
            .fillMaxWidth()
            .height(74.dp)
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = if (isSelected) iconEnable else iconDisable),
            contentDescription = ""
        )

        Image(
            painter = painterResource(id = R.drawable.ic_dot_selected),
            contentDescription = "",
            modifier = Modifier.padding(top = 3.dp),
            alpha = if (isSelected) 1f else 0f
        )
    }
}

fun NavHostController.switchTab(route: String) {
    val startDestination = graph.findStartDestination().id
    navigate(route) {
        popUpTo(startDestination) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
