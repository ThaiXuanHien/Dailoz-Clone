package com.hienthai.dailoz_clone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
import com.hienthai.dailoz_clone.screens.login.LOGIN_ROUTE
import com.hienthai.dailoz_clone.screens.login.LoginScreen
import com.hienthai.dailoz_clone.screens.signup.SIGNUP_ROUTE
import com.hienthai.dailoz_clone.screens.signup.SignUpScreen
import com.hienthai.dailoz_clone.screens.splash.SPLASH_ROUTE
import com.hienthai.dailoz_clone.screens.splash.SplashScreen
import com.hienthai.dailoz_clone.ui.theme.DailozCloneTheme

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailozCloneTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraphFirst(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavGraphFirst(navController: NavHostController) {
    val mContext = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE
    ) {
        composable(SPLASH_ROUTE) {
            SplashScreen(
                onLogin = {
                    navController.navigate(LOGIN_ROUTE)
                }, onSingUp = {
                    navController.navigate(SIGNUP_ROUTE)
                })
        }

        composable(LOGIN_ROUTE) {
            LoginScreen {
                mContext.startActivity(Intent(mContext, MainActivity::class.java))
            }
        }

        composable(SIGNUP_ROUTE) {
            SignUpScreen {
                mContext.startActivity(Intent(mContext, MainActivity::class.java))
            }
        }

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

    }
}