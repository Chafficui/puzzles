package puzzle.aoc.y2024

import core.BaseSolution
import core.Puzzle
import core.PuzzleOrigin
import core.PuzzlePart

class Day1(): BaseSolution() {
    override val puzzle = Puzzle.YEAR_2024
    override val day = 1
    override val origin = PuzzleOrigin.ADVENT_OF_CODE

    override fun getParts(): List<PuzzlePart> {
        return listOf(
            PuzzlePart(1, this::solvePart1),
            PuzzlePart(2, this::solvePart2)
        )
    }

    private fun solvePart1(input: List<String>): Int {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()

        input.forEach { line ->
            if (line.isNotBlank()) {
                val parts = line.split(" ").filter { it.isNotEmpty() }
                if (parts.size == 2) {
                    val (left, right) = parts.map { it.toInt() }
                    leftList.add(left)
                    rightList.add(right)
                }
            }
        }

        leftList.sort()
        rightList.sort()

        return leftList.indices.sumOf { index ->
            kotlin.math.abs(leftList[index] - rightList[index])
        }
    }

    private fun solvePart2(input: List<String>): Int {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()

        input.forEach { line ->
            if (line.isNotBlank()) {
                val parts = line.split(" ").filter { it.isNotEmpty() }
                if (parts.size == 2) {
                    val (left, right) = parts.map { it.toInt() }
                    leftList.add(left)
                    rightList.add(right)
                }
            }
        }

        val rightFrequency = rightList.groupingBy { it }.eachCount()

        return leftList.sumOf { number ->
            val countInRight = rightFrequency[number] ?: 0
            number * countInRight
        }
    }
}