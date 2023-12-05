package com.hienthai.dailoz_clone

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import kotlin.math.ceil

object DateUtil {



    private fun Date.isToday(): Boolean {
        val currentCalendar = Calendar.getInstance()
        val currentYear = currentCalendar.get(Calendar.YEAR)
        val currentMonth = currentCalendar.get(Calendar.MONTH)
        val currentDay = currentCalendar.get(Calendar.DAY_OF_YEAR)

        val beforeCalendar = Calendar.getInstance().apply { time = this@isToday }
        val beforeYear = beforeCalendar.get(Calendar.YEAR)
        val beforeMonth = beforeCalendar.get(Calendar.MONTH)
        val beforeDay = beforeCalendar.get(Calendar.DAY_OF_YEAR)
        return currentDay == beforeDay
                && currentYear == beforeYear
                && currentMonth == beforeMonth
    }



    fun getCurrentStringTimeGMT(format: String): String {
        val date = getDateTimeInGMT()
        val dateFormat = SimpleDateFormat(
            format,
            Locale.getDefault()
        )
        return dateFormat.format(date)
    }

    fun convertServerTime(
        time: String,
        fromFormat: String,
        toFormat: String,
        timeZone: TimeZone? = TimeZones.GMT
    ): String {
        convertTimeToDate(time, fromFormat, TimeZones.GMT)?.let {
            return convertDateToTime(it, toFormat, timeZone)
        }
        return ""
    }

    fun convertTimeToDate(time: String, format: String, timeZone: TimeZone? = null): Date? {
        return try {
            val dateFormat = SimpleDateFormat(format, Locale.getDefault())
            timeZone?.let {
                dateFormat.timeZone = timeZone
            }
            dateFormat.parse(time)
        } catch (e: Exception) {
            null
        }
    }

    fun convertDateToTime(
        date: Date,
        format: String,
        timeZone: TimeZone? = TimeZone.getDefault(),
        locale: Locale = Locale.getDefault()
    ): String {
        return try {
            val dateFormat = SimpleDateFormat(format, locale)
            timeZone?.let {
                dateFormat.timeZone = timeZone
            }
            dateFormat.format(date)
        } catch (e: Exception) {
            ""
        }
    }

    private fun getDateTimeInGMT(): Date {
        val calendar = Calendar.getInstance()
        calendar.timeZone = TimeZone.getTimeZone("GMT")
        return calendar.time
    }

    fun getTimeStringFromDate(
        date: Date,
        format: String,
        timeZone: TimeZone = TimeZone.getDefault(),
        local: Locale = Locale.getDefault()
    ): String {
        return try {
            val dateFormat = SimpleDateFormat(format, local)
            dateFormat.timeZone = timeZone
            dateFormat.format(date)
        } catch (e: Exception) {
            ""
        }
    }

    fun getLocalOffset(): Int {
        val cal = Calendar.getInstance()
        return (cal.get(Calendar.ZONE_OFFSET) +
                cal.get(Calendar.DST_OFFSET)) / (60 * 1000) / 60
    }


    fun getBetweenTwoDate(lastTimeLogin: Long): String {

        val time = (System.currentTimeMillis() / 1000) - (lastTimeLogin / 1000)

        val minute = time / 60
        val hour = minute / 60
        val day = hour / 24

        return when {
            day > 0 -> "$day 日前"
            hour > 0 -> "$hour 時間前"
            minute > 0 -> "$minute 分前"
            else -> "数秒前"
        }

    }

    fun timeToMonth(timeStamp: Long): String {
        val format = "MM月"
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date(timeStamp))
    }

    fun timeToMonthDay(timeStamp: Long): String {
        val format = "M月d日"
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date(timeStamp))
    }

    fun timeToWeekDay(timeStamp: Long): String {
        val format = "M月d日"
        val start = getTimeStringFromDate(Date(timeStamp), format)
        val end = getTimeStringFromDate(
            getLastDayOfWeekInMonth(Date(timeStamp)),
            format
        )
        return "$start ~ $end"
    }

    private fun getLastDayOfWeekInMonth(from: Date): Date {
        val fromCal = Calendar.getInstance()
        fromCal.time = from

        val toCal = Calendar.getInstance()
        toCal.time = from
        toCal.add(Calendar.DATE, 6)

        if (isDateSameMonth(fromCal.time, toCal.time)) {
            return toCal.time
        }
        val lastDay = fromCal.getActualMaximum(Calendar.DATE)
        fromCal.set(Calendar.DAY_OF_MONTH, lastDay)
        return fromCal.time
    }

    private fun isDateSameMonth(from: Date, to: Date): Boolean {
        val fromCal = Calendar.getInstance()
        fromCal.time = from
        val toCal = Calendar.getInstance()
        toCal.time = to
        return fromCal.get(Calendar.MONTH) == toCal.get(Calendar.MONTH)
    }

    fun timeToYear(timeStamp: Long): String {
        val format = "yyyy年"
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date(timeStamp))
    }

    fun timeToYearMonth(timeStamp: Long): String {
        val format = "yyyy年MM月"
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date(timeStamp))
    }

    fun getBetweenTwoDate(startDate: String): Long {

        return ceil((TimeUnit.DAYS.toMillis(30) -
                (System.currentTimeMillis() - (convertTimeToDate(
                    startDate,
                    TimeFormat.YYYYMMDDHHMM,
                    TimeZones.GMT
                )?.time ?: 0))).toDouble() / 1000 / 60 / 60 / 24).toLong()


    }

    fun convertDateFormat(sourceFormat: String, destFormat: String, date: String): String {
        val dateFormat = SimpleDateFormat(sourceFormat, Locale.getDefault())
        val sourceDate = dateFormat.parse(date) ?: Date()
        val targetDateFormat = SimpleDateFormat(destFormat, Locale.getDefault())
        return targetDateFormat.format(sourceDate)
    }

    fun convertLongToDateString(timestamp: Long): String {
        val dateFormat = SimpleDateFormat(TimeFormat.YYYYMMDDHHMMSS, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("GMT")
        val date = Date(timestamp)
        return dateFormat.format(date)
    }
}

object TimeFormat {
    const val D = "d"
    const val HHmm = "HHmm"
    const val HH_mm = "HH:mm"
    const val MM_DD = "MM/dd"
    const val MM_TEXT = "MM月"
    const val YYYY_MM_TEXT = "yyyy年MM月"
    const val MM_D_TEXT = "MM月d日"
    const val YYYYMM = "yyyyMM"
    const val YYYYMMDD = "yyyyMMdd"
    const val DDMMMYYYY = "dd MMM yyyy"
    const val YYYY_MM_DD = "yyyy/MM/dd"
    const val YYYY_MM_DD_2 = "yyyy-MM-dd"
    const val YYYY_MM_DD_HH_MM = "yyyy/MM/dd HH:mm"
    const val YYYYMMDDHHMM = "yyyyMMddHHmm"
    const val YYYYMMDDHHMMSS = "yyyyMMddHHmmss"
    const val YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS"
    const val FORMAT_DISPLAY_DAY_MONTH_HOUR = "MM/dd HH:mm"
}

object TimeZones {
    val GMT: TimeZone get() = TimeZone.getTimeZone("GMT")
    val JAPAN: TimeZone get() = TimeZone.getTimeZone("GMT+9")
    val LOCAL: TimeZone get() = TimeZone.getDefault()
}


