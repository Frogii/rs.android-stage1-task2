package subtask5

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            String::class -> {
                val output = blockA.filterIsInstance<String>()
                val builder = StringBuilder()
                for (i in output) builder.append(i)
                return builder.toString()
            }
            Int::class -> {
                val output = blockA.filterIsInstance<Int>()
                return output.sum()
            }
            else -> {
                val output = blockA.filterIsInstance<LocalDate>()
                return if (output.size == 1) {
                    output[0].toString()
                } else {
                    val arr = mutableListOf<Long>()
                    for (i in output) {
                        if(i.toEpochDay() <= LocalDate.now().toEpochDay())
                        arr.add(i.toEpochDay()-365)
                    }
                    arr.sort()
                    val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY")
                    return LocalDate.ofEpochDay(arr.last()).format(formatter)
                }
            }
        }
    }
}
