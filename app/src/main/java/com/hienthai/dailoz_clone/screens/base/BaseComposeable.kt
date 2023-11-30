package com.hienthai.dailoz_clone.screens.base

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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
            focusedIndicatorColor = colorResource(id = R.color.base_color),
            unfocusedIndicatorColor = colorResource(id = R.color.color_disable),
            focusedLeadingIconColor = colorResource(id = R.color.base_color),
            unfocusedLeadingIconColor = colorResource(id = R.color.color_disable),
            cursorColor = colorResource(id = R.color.base_color),
            textColor = Color.Black
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
                if (!isShowPassword) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hide_pw),
                        contentDescription = "",
                        tint = colorResource(id = R.color.color_disable),
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hide_pw),
                        contentDescription = "",
                        tint = colorResource(id = R.color.base_color),
                    )
                }
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
            focusedIndicatorColor = colorResource(id = R.color.base_color),
            unfocusedIndicatorColor = colorResource(id = R.color.color_disable),
            focusedLeadingIconColor = colorResource(id = R.color.base_color),
            unfocusedLeadingIconColor = colorResource(id = R.color.color_disable),
            cursorColor = colorResource(id = R.color.base_color),
            textColor = Color.Black
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseSearch() {
    var text by remember { mutableStateOf("") }
    val isTextNotEmpty by remember {
        derivedStateOf {
            mutableStateOf(text.isNotEmpty())
        }
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.dp, Color.Transparent),
        value = text,
        onValueChange = {
            text = it
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "ic_search",
                tint = colorResource(id = R.color.color_tint_disable),
            )
        },
        trailingIcon = {
            if (isTextNotEmpty.value) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clear),
                    contentDescription = "ic_clear",
                    tint = colorResource(id = R.color.base_color),
                    modifier = Modifier.size(24.dp).clickable { text = "" }
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_clear),
                    contentDescription = "ic_clear",
                    tint = colorResource(id = R.color.color_tint_disable)
                )
            }


        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor = colorResource(id = R.color.color_bg_search),
            cursorColor = colorResource(R.color.base_color),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(15.dp),
        placeholder = {
            Text(
                text = "Search for task",
                color = colorResource(id = R.color.color_text_hint_search)
            )
        },


        )
}

@Preview
@Composable
fun BaseSearchPreview() {
    BaseSearch()
}

@Composable
fun FilterView() {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = colorResource(id = R.color.color_bg_search))
            .padding(13.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "ic_filter"
        )
    }
}

@Preview
@Composable
fun FilterPreview() {
    FilterView()
}