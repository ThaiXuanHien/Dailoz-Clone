package com.hienthai.dailoz_clone.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
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
import com.hienthai.dailoz_clone.screens.base.BaseTextField
import com.hienthai.dailoz_clone.screens.base.PasswordTextField

@Composable
fun LoginScreen(onGoHome : () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 100.dp, start = 36.dp, end = 36.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Column {
                    Text(
                        text = "Login",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.base_color)
                    )
                    Spacer(modifier = Modifier.height(74.dp))
                    BaseTextField(placeHolder = "Email ID or Username")
                    Spacer(modifier = Modifier.height(10.dp))
                    PasswordTextField()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Forgot Password ?",
                        color = colorResource(id = R.color.base_color),
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Spacer(modifier = Modifier.height(55.dp))
                    BaseButton(text = "Login", null) {
                        onGoHome()
                    }
                    Spacer(modifier = Modifier.height(55.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Divider(
                            modifier = Modifier.weight(1f),
                            color = colorResource(id = R.color.color_divider)
                        )
                        Text(
                            text = "or with",
                            color = colorResource(id = R.color.color_text_hint),
                            modifier = Modifier.padding(horizontal = 22.dp)
                        )
                        Divider(
                            modifier = Modifier.weight(1f),
                            color = colorResource(id = R.color.color_divider)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "ic_google"
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "ic_google"
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(id = R.color.color_text_content_splash),
                                fontSize = 14.sp
                            )
                        ) {
                            append("Don’t have an account?")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(id = R.color.color_text_content_splash).copy(
                                    0.8f
                                ),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(" Sign Up")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 44.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen {}
}

const val LOGIN_ROUTE = "login_route"