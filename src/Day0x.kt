fun main() {
    fun part1(input: List<String>): Long {

        return 1L
    }

    fun part2(input: List<String>): Long {

        return 1L
    }

    val testInput = readInputAsStringLines("Day0x_test")
    check(part1(testInput) == 1L)
    check(part2(testInput) == 1L)

    val input = readInputAsStringLines("Day0x")
    part1(input).println()
    part2(input).println()
}