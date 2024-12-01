import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()
        input.forEach { row ->
            val (left, right) = row.split("   ")
            leftList += left.toInt()
            rightList += right.toInt()
        }

        leftList.sort()
        rightList.sort()

        return leftList.zip(rightList).sumOf { (l, r) ->
            (l - r).absoluteValue
        }
    }

    fun part2(input: List<String>): Int {
        val leftList = mutableListOf<Int>()
        val rightListValueCounter = mutableMapOf<Int, Int>()
        input.forEach { row ->
            val (left, right) = row.split("   ")
            leftList += left.toInt()

            val rightValue = right.toInt()
            rightListValueCounter[rightValue] = rightListValueCounter.getOrDefault(rightValue, 0) + 1
        }

        return leftList.sumOf { leftValue ->
            leftValue * rightListValueCounter.getOrDefault(leftValue, 0)
        }
    }

    val testInput = readInputAsStringLines("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInputAsStringLines("Day01")
    part1(input).println() //1879048
    part2(input).println() //21024792
}