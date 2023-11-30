package com.hienthai.dailoz_clone.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.R
import com.hienthai.dailoz_clone.screens.base.BaseButton


@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.padding(horizontal = 42.dp),
                    painter = painterResource(id = R.drawable.img_logo),
                    contentDescription = ""
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 55.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TextAppName()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.color_text_content_splash),
                        textAlign = TextAlign.Center,
                        text = "Plan what you will do to be more organized for today, tomorrow and beyond"
                    )
                    Spacer(modifier = Modifier.height(65.dp))
                    BaseButton(text = "Login", 36.dp) {

                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        fontSize = 16.sp,
                        color = colorResource(R.color.base_color),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        text = "Sign Up"
                    )
                }
            }
        }
    }
}

@Composable
fun TextAppName() {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.base_color),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Dailoz")
        }
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.color_dot),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(".")
        }
    })
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}