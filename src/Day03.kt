fun main() {
    fun part1(input: String): Int {
        val matchingListMul =
            """mul\(\d{1,3},\d{1,3}\)""".trimIndent().toRegex(RegexOption.MULTILINE).findAll(input).toList()
        return matchingListMul.sumOf { match ->
            val (v1, v2) = """\d+""".toRegex().findAll(match.value).map { it.value.toInt() }.toList()
            v1 * v2
        }
    }

    fun part2(input: String): Int {
        val matchingList =
            """(mul\(\d{1,3},\d{1,3}\)|do\(\)|don't\(\))""".trimIndent().toRegex(RegexOption.MULTILINE).findAll(input)

        var sum = 0

        var doCalculation = true

        matchingList.forEach { match ->
            if (match.value.startsWith("do(")) {
                doCalculation = true
            } else if (match.value.startsWith("don")) {
                doCalculation = false
            } else if (doCalculation) {
                val (v1, v2) = """\d+""".toRegex().findAll(match.value).map { it.value.toInt() }.toList()
                sum += v1 * v2
            }
        }

        return sum
    }

    val testInput = readInputAsString("Day03_test")
    val testInputPart2 = readInputAsString("Day03_test_2")
    check(part1(testInput) == 161)
    check(part2(testInputPart2) == 48)

    val input = readInputAsString("Day03")
    part1(input).println() //170807108
    part2(input).println() //74838033
}