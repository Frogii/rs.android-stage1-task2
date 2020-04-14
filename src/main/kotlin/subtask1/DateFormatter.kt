package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        val date: LocalDate

        try {
            date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch (e: DateTimeException) {
            return "Такого дня не существует"
        }
        val formatter = DateTimeFormatter.ofPattern("d MMMM").withLocale(Locale("ru"))
        val formDate = date.format(formatter)

        return ("$formDate, ${date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("RU"))}".toLowerCase())

    }
}
