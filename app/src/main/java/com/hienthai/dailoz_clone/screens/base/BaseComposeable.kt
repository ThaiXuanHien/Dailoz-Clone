package com.hienthai.dailoz_clone.screens.base

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.graphics.painter.Painter
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
import com.hienthai.dailoz_clone.DateUtil
import com.hienthai.dailoz_clone.R
import com.hienthai.dailoz_clone.TimeFormat
import com.hienthai.dailoz_clone.calendar.CalendarApp
import com.hienthai.dailoz_clone.screens.home.Tag
import com.hienthai.dailoz_clone.ui.theme.text
import com.hienthai.dailoz_clone.ui.theme.textBold
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Date
import java.util.Locale


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
    TextField(value = "", onValueChange = {}, placeholder = {
        Text(
            text = placeHolder,
            fontSize = 16.sp,
            color = colorResource(id = R.color.color_text_hint)
        )
    }, singleLine = true, leadingIcon = {
        Icon(
            painter = painterResource(R.drawable.ic_email), contentDescription = "print"
        )
    }, modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.textFieldColors(
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
                text = "Password",
                fontSize = 16.sp,
                color = colorResource(id = R.color.color_text_hint)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_password), contentDescription = "print"
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
        visualTransformation = if (!isShowPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth(),
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
                Icon(painter = painterResource(id = R.drawable.ic_clear),
                    contentDescription = "ic_clear",
                    tint = colorResource(id = R.color.base_color),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { text = "" })
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
                text = "Search for task", color = colorResource(id = R.color.color_text_hint_search)
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
            painter = painterResource(id = R.drawable.ic_filter), contentDescription = "ic_filter"
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
    listColor: List<Color>,
    onClickCategory : () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable {
                onClickCategory()
            }
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
                    painter = painterResource(id = resourceId), contentDescription = "img_category"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = title, fontSize = 16.sp, color = colorResource(id = colorText)
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

@Preview
@Composable
fun CategoryTaskImagePreview() {
    ItemCategoryTask(
        R.drawable.img_imac, "Completed", 86, R.color.color_text_item_category, listOf(
            Color.fromHex("7DC8E7"), Color.fromHex("B07DC8E7")
        )
    ) {}
}


@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun ListCategory() {
//    LazyVerticalStaggeredGrid(
//        userScrollEnabled = false,
//        columns = StaggeredGridCells.Fixed(2),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalItemSpacing = 16.dp
//    ) {
//        item {
//            ItemCategoryTask(
//                resourceId = R.drawable.img_imac,
//                title = "Completed",
//                numberTask = 86,
//                colorText = R.color.color_text_item_category,
//                listOf(
//                    Color.fromHex("7DC8E7"), Color.fromHex("B07DC8E7")
//                )
//            )
//        }
//        item {
//            ItemCategoryTask(
//                resourceId = R.drawable.ic_time,
//                title = "Pending",
//                numberTask = 15,
//                colorText = R.color.white,
//                listOf(
//                    Color.fromHex("7D88E7"), Color.fromHex("BD7D88E7")
//                )
//            )
//        }
//        item {
//            ItemCategoryTask(
//                resourceId = R.drawable.ic_folder,
//                title = "On Going",
//                numberTask = 67,
//                colorText = R.color.color_text_item_category,
//                listOf(
//                    Color.fromHex("81E89E"), Color.fromHex("5981E89E")
//                )
//            )
//        }
//        item {
//            ItemCategoryTask(
//                resourceId = R.drawable.ic_cancel,
//                title = "Canceled",
//                numberTask = 15,
//                colorText = R.color.white,
//                listOf(
//                    Color.fromHex("E77D7D"), Color.fromHex("B5E77D7D")
//                )
//            )
//        }
//    }
//}


@Composable
fun TwoByTwoColumn(
    onClickCompleted : () -> Unit,
    onClickPending : () -> Unit,
    onClickCanceled : () -> Unit,
    onClickOnGoing : () -> Unit,
) {
    Row(
        modifier = Modifier
            .wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            ItemCategoryTask(
                resourceId = R.drawable.img_imac,
                title = "Completed",
                numberTask = 86,
                colorText = R.color.color_text_item_category,
                listOf(
                    Color.fromHex("7DC8E7"), Color.fromHex("B07DC8E7")
                )
            ) {
                onClickCompleted()
            }
            Spacer(modifier = Modifier.height(16.dp))
            ItemCategoryTask(
                resourceId = R.drawable.ic_cancel,
                title = "Canceled",
                numberTask = 15,
                colorText = R.color.white,
                listOf(
                    Color.fromHex("E77D7D"), Color.fromHex("B5E77D7D")
                )
            ) {
                onClickCanceled()
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            ItemCategoryTask(
                resourceId = R.drawable.ic_time,
                title = "Pending",
                numberTask = 15,
                colorText = R.color.white,
                listOf(
                    Color.fromHex("7D88E7"), Color.fromHex("BD7D88E7")
                )
            ) {
                onClickPending()
            }
            Spacer(modifier = Modifier.height(16.dp))
            ItemCategoryTask(
                resourceId = R.drawable.ic_folder,
                title = "On Going",
                numberTask = 67,
                colorText = R.color.color_text_item_category,
                listOf(
                    Color.fromHex("81E89E"), Color.fromHex("5981E89E")
                )
            ) {
                onClickOnGoing()
            }
        }
    }
}

@Preview
@Composable
fun TwoByTwoColumnPreview() {
    TwoByTwoColumn({},{},{},{})
}

//@Preview
//@Composable
//fun ListCategoryPreview() {
//    ListCategory()
//}


@Composable
fun ItemTask(title: String, colorItem: Int, colorDivider: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = colorResource(id = colorItem))
            .padding(15.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                Divider(
                    color = colorResource(id = colorDivider),
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(2.dp))
                        .width(2.dp)
                )
                Spacer(
                    modifier = Modifier.width(8.dp)
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
                modifier = Modifier.width(8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                val listTag = listOf(
                    Tag(
                        "Home", R.color.color_tag_home
                    ), Tag(
                        "Office", R.color.color_tag_office
                    ), Tag(
                        "Urgent", R.color.color_tag_urgent
                    ), Tag(
                        "Work", R.color.color_tag_work
                    )
                )
                listTag.forEach {
                    ItemTag(it)
                }
            }
        }

    }
}

@Preview
@Composable
fun ItemTaskPreview() {
    ItemTask("Cleaning Clothes", R.color.color_bg_item_task, R.color.color_tag_office)
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
            text = tag.content, fontSize = 10.sp, color = colorResource(id = tag.color)
        )
    }
}

@Preview
@Composable
fun ItemTagPreview() {
    ItemTag(Tag("Urgent", R.color.base_color))
}

@Composable
fun TopBar(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White.copy(0.8f))
            .padding(bottom = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 1.dp,
                    spotColor = colorResource(id = R.color.base_color),
                    shape = RoundedCornerShape(15.dp)
                )
                .background(Color.White)
                .padding(12.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = "avatar"
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            text = title,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar("Pending")
}

@Composable
fun ItemCategoryTask() {
    Column(modifier = Modifier.wrapContentSize()) {
        Text(
            text = DateUtil.convertDateToTime(Date(), TimeFormat.DDMMMYYYY),
            color = colorResource(id = R.color.color_title_task_category),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .horizontalScroll(
                    rememberScrollState()
                ), horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat((0..2).count()) {
                ItemTask(
                    title = "Cleaning Clothes ",
                    colorItem = R.color.color_bg_item_task,
                    R.color.color_tag_office
                )
            }


        }
    }
}

@Preview
@Composable
fun ItemCategoryTaskPreview() {
    ItemCategoryTask()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTitleTextField(title: String, isShowTrailingIcon: Boolean) {
    Column {
        Text(
            text = title,
            color = colorResource(id = R.color.color_title_text_field),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "placeHolder",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.color_text_hint)
                )
            },
            trailingIcon = {
                if (isShowTrailingIcon) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "ic_calendar",
                        tint = colorResource(id = R.color.base_color),
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
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
}

@Preview
@Composable
fun BaseTitleTextFieldPreview() {
    BaseTitleTextField("title", false)
}


@Composable
fun TaskTypeCheckbox(
    isChecked: Boolean,
    checkedIcon: Painter,
    uncheckedIcon: Painter,
    onCheckedChange: ((Boolean) -> Unit)?,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Image(painter = if (isChecked) checkedIcon else uncheckedIcon,
        contentDescription = "",
        modifier = Modifier
            .size(18.dp)
            .padding(1.dp)
            .clickable(
                interactionSource = interactionSource, indication = null
            ) {
                onCheckedChange?.invoke(!isChecked)
            })
}

@Composable
fun CheckBoxGroup() {
    val (checkedStatePersonal, onCheckedChangePersonal) = remember { mutableStateOf(false) }
    val (checkedStatePrivate, onCheckedChangePrivate) = remember { mutableStateOf(false) }
    val (checkedStateSecret, onCheckedChangeSecret) = remember { mutableStateOf(false) }

    val checkedIcon = painterResource(id = R.drawable.ic_checked)
    val uncheckedIcon = painterResource(id = R.drawable.ic_unchecked)

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            TaskTypeCheckbox(
                isChecked = checkedStatePersonal,
                checkedIcon = checkedIcon,
                uncheckedIcon = uncheckedIcon,
                onCheckedChange = onCheckedChangePersonal
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Personal",
                fontSize = 16.sp,
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            TaskTypeCheckbox(
                isChecked = checkedStatePrivate,
                checkedIcon = checkedIcon,
                uncheckedIcon = uncheckedIcon,
                onCheckedChange = onCheckedChangePrivate
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Private",
                fontSize = 16.sp,
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            TaskTypeCheckbox(
                isChecked = checkedStateSecret,
                checkedIcon = checkedIcon,
                uncheckedIcon = uncheckedIcon,
                onCheckedChange = onCheckedChangeSecret
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Secret",
                fontSize = 16.sp,
            )
        }
    }
}

@Preview
@Composable
fun CheckboxPreview() {
    CheckBoxGroup()
}

@Composable
fun ItemTagRoundedCircle(tag: Tag) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(22.dp))
            .background(color = colorResource(id = tag.color).copy(0.3f))
            .padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
        Text(
            text = tag.content, fontSize = 14.sp, color = colorResource(id = tag.color)
        )
    }
}

@Preview
@Composable
fun ItemTagRoundedCirclePreview() {
    ItemTagRoundedCircle(Tag("Urgent", R.color.base_color))
}

@Composable
fun AddTaskSimpleTextField(
    textState: MutableState<String>,
    textHint: String = "",
    isTaskToCenter: Boolean = false,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    isReadOnly: Boolean = false,
    isSingleLine: Boolean = true,
    startIcon: Int = -1,
    endIcon: Int = -1,
    iconColor: Color = colorResource(id = R.color.color_purple_white),
    onClickTextField: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClickTextField
            )
    ) {
        BasicTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier.fillMaxWidth(),
            readOnly = isReadOnly,
            singleLine = isSingleLine,
            textStyle = textBold.copy(
                color = colorResource(id = R.color.title_back_action_bar),
                fontSize = 15.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 15.dp,
                            bottom = 15.dp,
                            start = if (startIcon != -1) 3.dp else 0.dp,
                            end = if (endIcon != -1) 3.dp else 0.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (startIcon != -1) {
                        Icon(
                            painter = painterResource(id = startIcon),
                            contentDescription = "Start Icon",
                            tint = iconColor
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                    }

                    Box(

                        modifier = Modifier.weight(1f)
                    ) {
                        innerTextField()
                        if (textState.value.isEmpty()) {
                            Text(
                                text = textHint,
                                modifier = if (isTaskToCenter) Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterStart) else Modifier,
                                style = text.copy(
                                    color = colorResource(id = R.color.color_text_hint),
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }

                    if (endIcon != -1) {
                        Icon(
                            painter = painterResource(id = endIcon),
                            contentDescription = "End Icon",
                            tint = iconColor
                        )
                    }
                }
            }
        )

        Divider(
            color = colorResource(id = R.color.color_divider),
            thickness = 1.dp
        )
    }

}

@Preview
@Composable
fun CalendarPreview() {
    CalendarApp()
}

fun Color.Companion.fromHex(colorString: String) =
    Color(android.graphics.Color.parseColor("#$colorString"))
