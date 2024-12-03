fun main() {
    fun part1(input: List<String>): Int {
        return -1
    }

    fun part2(input: List<String>): Int {
        return -1
    }

    val testInput = readInputAsStringLines("Day04_test")
    check(part1(testInput) == 1)
    check(part2(testInput) == 1)

    val input = readInputAsStringLines("Day04")
    part1(input).println()
    part2(input).println()
}