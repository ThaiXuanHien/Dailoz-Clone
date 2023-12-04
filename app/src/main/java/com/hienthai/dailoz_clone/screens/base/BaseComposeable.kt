package com.hienthai.dailoz_clone.screens.base

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.R
import com.hienthai.dailoz_clone.screens.home.Tag


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
            unfocusedIndicatorColor = colorResource(id = R.color.color_divider),
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
            unfocusedIndicatorColor = colorResource(id = R.color.color_divider),
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
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { text = "" }
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

@Composable
fun ItemCategoryTask(
    resourceId: Int,
    title: String,
    numberTask: Int,
    colorText: Int,
    listColor: List<Color>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 14.dp,
                ambientColor = Color.fromHex("7DC8E7"),
                spotColor = Color.fromHex("7DC8E7")
            ),
        elevation = CardDefaults.cardElevation(14.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listColor
                    )
                )
                .padding(15.dp)

        ) {
            Row(modifier = Modifier.wrapContentWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = resourceId),
                        contentDescription = "img_category"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        color = colorResource(id = colorText)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$numberTask Task",
                        fontSize = 14.sp,
                        color = colorResource(id = colorText)
                    )
                }
                Icon(

                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "ic_arrow",
                    tint = colorResource(id = colorText)
                )
            }
        }
    }
}

@Preview
@Composable
fun CategoryTaskImagePreview() {
    ItemCategoryTask(
        R.drawable.img_imac,
        "Completed",
        86,
        R.color.color_text_item_category,
        listOf(
            Color.fromHex("7DC8E7"),
            Color.fromHex("B07DC8E7")
        )
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListCategory() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        item {
            ItemCategoryTask(
                resourceId = R.drawable.img_imac,
                title = "Completed",
                numberTask = 86,
                colorText = R.color.color_text_item_category,
                listOf(
                    Color.fromHex("B07DC8E7"),
                    Color.fromHex("7DC8E7")
                )
            )
        }
        item {
            ItemCategoryTask(
                resourceId = R.drawable.ic_time,
                title = "Pending",
                numberTask = 15,
                colorText = R.color.white,
                listOf(
                    Color.fromHex("BD7D88E7"),
                    Color.fromHex("7D88E7")
                )
            )
        }
        item {
            ItemCategoryTask(
                resourceId = R.drawable.ic_folder,
                title = "On Going",
                numberTask = 67,
                colorText = R.color.color_text_item_category,
                listOf(
                    Color.fromHex("5981E89E"),
                    Color.fromHex("81E89E")
                )
            )
        }
        item {
            ItemCategoryTask(
                resourceId = R.drawable.ic_cancel,
                title = "Canceled",
                numberTask = 15,
                colorText = R.color.white,
                listOf(
                    Color.fromHex("B5E77D7D"),
                    Color.fromHex("E77D7D")
                )
            )
        }
    }
}

@Preview
@Composable
fun ListCategoryPreview() {
    ListCategory()
}


@Composable
fun ItemTask(title: String, colorItem: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = colorResource(id = colorItem))
            .padding(15.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
            ) {
                Divider(
                    color = colorResource(id = colorItem),
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(2.dp))
                        .width(2.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.color_text_content_splash)
                    )
                    Text(
                        text = "07:00 - 07:15",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.color_text_time_item_task)
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_more),
                    contentDescription = "ic_more"
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(start = 8.dp)
            ) {
                val listTag = listOf(
                    Tag(
                        "Home",
                        R.color.color_tag_home
                    ),
                    Tag(
                        "Office",
                        R.color.color_tag_office
                    ),
                    Tag(
                        "Urgent",
                        R.color.color_tag_urgent
                    ),
                    Tag(
                        "Work",
                        R.color.color_tag_work
                    )
                )
                items(items = listTag) { tag ->
                    ItemTag(tag)
                }
            }
        }

    }
}

@Preview
@Composable
fun ItemTaskPreview() {
    ItemTask("Cleaning Clothes", R.color.color_bg_item_task)
}

@Composable
fun ItemTag(tag: Tag) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(3.dp))
            .background(color = colorResource(id = tag.color).copy(0.3f))
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Text(
            text = tag.content,
            fontSize = 10.sp,
            color = colorResource(id = tag.color)
        )
    }

}

@Preview
@Composable
fun ItemTagPreview() {
    ItemTag(Tag("Urgent", R.color.base_color))
}

fun Color.Companion.fromHex(colorString: String) =
    Color(android.graphics.Color.parseColor("#$colorString"))
