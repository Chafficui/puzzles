package puzzle.aoc.y2024

import core.BaseSolution
import core.Puzzle
import core.PuzzleOrigin
import core.PuzzlePart

class Day2(): BaseSolution() {
    override val puzzle = Puzzle.YEAR_2024
    override val day = 2
    override val origin = PuzzleOrigin.ADVENT_OF_CODE

    override fun getParts(): List<PuzzlePart> {
        return listOf(
            PuzzlePart(1, this::solvePart1),
            PuzzlePart(2, this::solvePart2)
        )
    }

    private fun solvePart1(input: List<String>): Int {
        return input.count { line ->
            val levels = line.split(" ").map { it.toInt() }
            isSafeReport(levels)
        }
    }

    private fun isSafeReport(levels: List<Int>): Boolean {
        if (levels.size < 2) return false

        val deltas = levels.zipWithNext { a, b -> b - a }

        val allIncreasing = deltas.all { it in 1..3 }
        val allDecreasing = deltas.all { it in -3..-1 }

        return allIncreasing || allDecreasing
    }

    private fun solvePart2(input: List<String>): Int {
        return input.count { line ->
            val levels = line.split(" ").map { it.toInt() }
            isSafeReport(levels) || canBeMadeSafe(levels)
        }
    }

    private fun canBeMadeSafe(levels: List<Int>): Boolean {
        for (i in levels.indices) {
            val modifiedLevels = levels.filterIndexed { index, _ -> index != i }
            if (isSafeReport(modifiedLevels)) return true
        }
        return false
    }
}