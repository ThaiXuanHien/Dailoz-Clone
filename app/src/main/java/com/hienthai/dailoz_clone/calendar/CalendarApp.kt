package com.hienthai.dailoz_clone.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hienthai.dailoz_clone.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun CalendarApp(
    modifier: Modifier = Modifier,
) {
    val dataSource = CalendarDataSource()
    var data by remember { mutableStateOf(dataSource.getData(lastSelectedDate = dataSource.today)) }
    Column(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
//        Header(
//            data = data,
//            onPrevClickListener = { startDate ->
//                val finalStartDate = startDate.minusDays(1)
//                data = dataSource.getData(
//                    startDate = finalStartDate,
//                    lastSelectedDate = data.selectedDate.date
//                )
//            },
//            onNextClickListener = { endDate ->
//                val finalStartDate = endDate.plusDays(2)
//                data = dataSource.getData(
//                    startDate = finalStartDate,
//                    lastSelectedDate = data.selectedDate.date
//                )
//            }
//        )

        Text(
            text = "Task",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.color_text_content_splash)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Content(data = data) { date ->
            data = data.copy(
                selectedDate = date,
                visibleDates = data.visibleDates.map {
                    it.copy(
                        isSelected = it.date.isEqual(date.date)
                    )
                }
            )
        }
    }
}

@Composable
fun Header(
    data: CalendarUiModel,
    onPrevClickListener: (LocalDate) -> Unit,
    onNextClickListener: (LocalDate) -> Unit,
) {
    Row {
        Text(
            text = if (data.selectedDate.isToday) {
                "Today"
            } else {
                data.selectedDate.date.format(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                )
            },
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        IconButton(onClick = {
            onPrevClickListener(data.startDate.date)
        }) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Back"
            )
        }
        IconButton(onClick = {
            onNextClickListener(data.endDate.date)
        }) {
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Next"
            )
        }
    }
}

@Composable
fun Content(
    data: CalendarUiModel,
    onDateClickListener: (CalendarUiModel.Date) -> Unit,
) {
//    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 48.dp)) {
//        items(data.visibleDates.size) { index ->
//            ContentItem(
//                date = data.visibleDates[index],
//                onDateClickListener
//            )
//        }
//    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        (0 until 6).forEach {
            ContentItem(
                date = data.visibleDates[it],
                onDateClickListener
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentItem(
    date: CalendarUiModel.Date,
    onClickListener: (CalendarUiModel.Date) -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (date.isSelected) {
                    colorResource(id = R.color.base_color)
                } else {
                    Color.Transparent
                }
            )
            .padding(vertical = 5.dp, horizontal = 5.dp)
            .clickable {
                onClickListener(date)
            },

        ) {
        Column(
            modifier = Modifier
                .width(35.dp)
                .height(55.dp)
                .padding(4.dp)
        ) {
            Text(
                text = date.day,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = if (date.isSelected) R.color.white else R.color.black)
            )
            Box (Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
                Text(
                    text = date.date.dayOfMonth.toString(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = if (date.isSelected) R.color.white else R.color.black)
                )
            }

        }
    }
}

@Preview
@Composable
fun CalendarAppPreview() {
    CalendarApp()
}