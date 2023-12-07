package com.hienthai.dailoz_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.DateUtil.getCurrentDate
import com.hienthai.dailoz_clone.R
import com.hienthai.dailoz_clone.TimeFormat
import com.hienthai.dailoz_clone.screens.base.AddTaskSimpleTextField
import com.hienthai.dailoz_clone.screens.base.BaseButton
import com.hienthai.dailoz_clone.screens.base.BaseTitleTextField
import com.hienthai.dailoz_clone.screens.base.CheckBoxGroup
import com.hienthai.dailoz_clone.screens.base.ItemTagRoundedCircle
import com.hienthai.dailoz_clone.screens.base.TopBar
import com.hienthai.dailoz_clone.screens.home.Tag

@Composable
fun AddTagScreen() {
    val currentDate = getCurrentDate(TimeFormat.D_MMMM_YYYY)
    val currentHour = getCurrentDate(TimeFormat.HH_MM_a)
    val textStartTimeState = remember { mutableStateOf(currentHour) }
    val textEndTimeState = remember { mutableStateOf(currentHour) }


    Box(modifier = Modifier.background(Color.White).padding(24.dp)) {
        Column {
            TopBar(title = "Add Task")
            Spacer(Modifier.height(10.dp).background(Color.White.copy(0.8f)))
            Column(Modifier.verticalScroll(rememberScrollState())) {
                BaseTitleTextField(title = "Title", false)
                Spacer(modifier = Modifier.height(20.dp))
                BaseTitleTextField(title = "Date", isShowTrailingIcon = true)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Time",
                    color = colorResource(id = R.color.color_title_text_field),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    AddTaskSimpleTextField(
                        textState = textStartTimeState,
                        isTaskToCenter = true,
                        modifier = Modifier.weight(1f),
                        isReadOnly = true
                    ) {}
                    Spacer(modifier = Modifier.width(15.dp))
                    AddTaskSimpleTextField(
                        textState = textEndTimeState,
                        isTaskToCenter = true,
                        modifier = Modifier.weight(1f),
                        isReadOnly = true
                    ) {}
                }
                Spacer(modifier = Modifier.height(20.dp))
                BaseTitleTextField(title = "Description", isShowTrailingIcon = false)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Type",
                    color = colorResource(id = R.color.color_title_text_field),
                    fontSize = 14.sp
                )
                Row() {
                    AddTaskSimpleTextField(
                        textState = textStartTimeState,
                        isTaskToCenter = true,
                        modifier = Modifier.weight(1f),
                        isReadOnly = true
                    ) {}
                    Spacer(modifier = Modifier.width(15.dp))
                    AddTaskSimpleTextField(
                        textState = textEndTimeState,
                        isTaskToCenter = true,
                        modifier = Modifier.weight(1f),
                        isReadOnly = true
                    ) {}
                }
                Spacer(modifier = Modifier.height(20.dp))
                CheckBoxGroup()
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Tags",
                    color = colorResource(id = R.color.color_title_text_field),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    ItemTagRoundedCircle(
                        Tag(
                            "Home",
                            R.color.color_tag_home
                        )
                    )
                    ItemTagRoundedCircle(
                        Tag(
                            "Office",
                            R.color.color_tag_office
                        )
                    )
                    ItemTagRoundedCircle(
                        Tag(
                            "Urgent",
                            R.color.color_tag_urgent
                        )
                    )
                    ItemTagRoundedCircle(
                        Tag(
                            "Work",
                            R.color.color_tag_work
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "+ Add new tag",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.color_text_add_new_task),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(38.dp))
                BaseButton(text = "Create", paddingHorizontal = null) {
                    
                }
            }
        }
    }
}

@Preview
@Composable
fun AddTagScreenPreview() {
    AddTagScreen()
}

const val ADD_TASK_ROUTE = "add_task_route"