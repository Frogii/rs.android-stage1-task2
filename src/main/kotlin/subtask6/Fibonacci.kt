package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {

        var first = 0
        var second = 1
        var proizved = first * second

        while (proizved < n) {
            val count = first
            first = second
            second += count
            proizved = first * second

        }
        return intArrayOf(first, second, if (proizved>n)0 else 1)


    }
}
