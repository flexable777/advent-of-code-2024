fun main() {
    fun part1(input: List<String>): Int {
        var safeCounter = 0

        input.forEach { line ->
            val levels = line.split(" ").map { it.toInt() }

            if (isReportSafe(levels.zipWithNext())) {
                safeCounter++
            }
        }

        return safeCounter
    }

    fun part2(input: List<String>): Int {
        var safeCounter = 0

        input.forEach { line ->
            val levels = line.split(" ").map { it.toInt() }

            var safe = false
            for (i in levels.indices) {
                val levelsToCheck = (levels.take(i) + levels.subList(i + 1, levels.size))
                if (isReportSafe(levelsToCheck.zipWithNext())) {
                    safe = true
                    break
                }
            }
            if (safe) {
                safeCounter++
            }
        }
        return safeCounter
    }

    val testInput = readInputAsStringLines("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInputAsStringLines("Day02")
    part1(input).println() //631
    part2(input).println() //665
}

//TODO combine
fun isReportSafe(levelPairs: List<Pair<Int, Int>>): Boolean {
    if (levelPairs[0].first > levelPairs[0].second) {
        for ((previous, current) in levelPairs) {
            if (previous <= current || (previous - current) > 3) {
                return false
            }
        }
    } else if (levelPairs[0].first < levelPairs[0].second) {
        for ((previous, current) in levelPairs) {
            if (previous >= current || (current - previous) > 3) {
                return false
            }
        }
    } else {
        return false
    }

    return true
}