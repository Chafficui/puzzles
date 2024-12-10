package puzzle.aoc.y2024

import core.BaseSolution
import core.Puzzle
import core.PuzzleOrigin
import core.PuzzlePart

class Day3(): BaseSolution() {
    override val puzzle = Puzzle.YEAR_2024
    override val day = 3
    override val origin = PuzzleOrigin.ADVENT_OF_CODE

    override fun getParts(): List<PuzzlePart> {
        return listOf(
            PuzzlePart(1, this::solvePart1),
            PuzzlePart(2, this::solvePart2)
        )
    }

    private fun solvePart1(input: List<String>): Int {
        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
        return input.sumOf { line ->
            regex.findAll(line).sumOf { match ->
                val (x, y) = match.destructured
                x.toInt() * y.toInt()
            }
        }
    }

    private fun solvePart2(input: List<String>): Int {
        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
        var isMulEnabled = true  // Start with mul enabled
        var result = 0

        input.forEach { line ->
            if (line.contains("do()")) {
                isMulEnabled = true
            } else if (line.contains("don't()")) {
                isMulEnabled = false
            }

            regex.findAll(line).forEach { match ->
                val (x, y) = match.destructured
                if (isMulEnabled) {
                    result += x.toInt() * y.toInt()
                }
            }
        }

        return result
    }
}