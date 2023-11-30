package com.hienthai.dailoz_clone.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.R


@Composable
fun BaseButton(text: String, paddingHorizontal: Dp?, onClick: () -> Unit) {
    Button(modifier = Modifier
        .height(52.dp)
        .fillMaxWidth()
        .padding(horizontal = paddingHorizontal ?: 0.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            colorResource(R.color.base_color)
        ),
        onClick = { onClick() }) {
        Text(
            text = text, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun BaseButtonPreview() {
    BaseButton(text = "Test", 36.dp) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTextField(placeHolder: String) {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(
                text = placeHolder,
                fontSize = 16.sp,
                color = colorResource(id = R.color.color_text_hint)
            )
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_email), contentDescription = "print"
            )
        }, modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { password = it },
        placeholder = {
            Text(
                text = "Password", fontSize = 16.sp,
                color = colorResource(id = R.color.color_text_hint)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_password),
                contentDescription = "print"
            )
        },
        trailingIcon = {
            IconButton(onClick = { isShowPassword = !isShowPassword }) {
                Icon(
                    painter = painterResource(
                        if (isShowPassword)
                            R.drawable.ic_show_pw
                        else R.drawable.ic_hide_pw
                    ),
                    contentDescription = "print"
                )
            }

        },
        singleLine = true,
        visualTransformation =
        if (!isShowPassword)
            PasswordVisualTransformation()
        else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        )
    )
}

@Preview
@Composable
fun BaseTextFieldPreview() {
    BaseTextField("Username")
}

@Preview
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextField()
}