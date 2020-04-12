package subtask2

import java.time.DateTimeException
import java.time.LocalTime

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        val time: LocalTime
        try {
            time = LocalTime.of(hour.toInt(), minute.toInt())
        } catch (e: DateTimeException) {
            return ""
        }
        val timeArr = listOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine"
        )
        val reversedTimeArr = timeArr.reversed()

        return when (time.minute) {
            0 -> "${timeArr[time.hour - 1]} o' clock"
            15 -> "quarter past ${timeArr[time.hour - 1]}"
            30 -> "half past ${timeArr[time.hour - 1]}"
            45 -> "quarter to ${timeArr[time.hour]}"
            in 1..30 -> "${timeArr[time.minute - 1]} minutes past ${timeArr[time.hour - 1]}"
            in 31..60 -> "${reversedTimeArr[time.minute - 31]} minutes to ${timeArr[time.hour]}"
            else -> ""
        }
    }
}
