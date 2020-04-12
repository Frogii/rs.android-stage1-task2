package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val arrA = a.toUpperCase().toMutableList()
        val arrB = b.toMutableList()
        val output: MutableList<Char> = mutableListOf()

        for (char in arrA) {
            if (arrB.contains(char)) output.add(char)

        }
        return if (output == arrB) "YES"
        else "NO"
    }
}
