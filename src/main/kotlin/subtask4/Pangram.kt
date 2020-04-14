package subtask4

class Pangram {

    private val alphabet = mutableListOf<Char>().apply {
        for (char in 'a'..'z') this.add(char)
    }
    private val vowels = mutableListOf('a', 'e', 'i', 'o', 'u', 'y')
    private val consonants = mutableListOf<Char>().apply {
        this.addAll(alphabet.filter { !vowels.contains(it) })
    }
    private var counter = 0
    fun getResult(inputString: String) = updateString(inputString, if (isPanagram(inputString.toLowerCase())) vowels else consonants)

    private fun isPanagram(inputString: String): Boolean {
        for (char in alphabet) {
            if (inputString.indexOf(char) == -1) return false
        }
        return true
    }

    private fun updateString(inputString: String, chars: List<Char>): String {
        val resultArr = inputString.split(" ").filter { it.trim().isNotEmpty() }.map { word ->
            var updatedWord = word
            counter = 0
            chars.map { char ->
                if (updatedWord.toLowerCase().contains(char)) {
                    updatedWord = updateWord(updatedWord, char)
                }
            }

            return@map "$counter$updatedWord"
        }.sortedBy { it.first() }
        var resultStr = ""
        resultArr.map { resultStr+= "$it " }

        return resultStr.trim()
    }

    private fun updateWord(word: String, char: Char): String {
        val charArr = word.toCharArray()
        for (index in charArr.indices) {
            if (charArr[index] == char || charArr[index] == char.toUpperCase()) {
                counter++
                charArr[index] = char.toUpperCase()
            }
        }
        return String(charArr)
    }
}
