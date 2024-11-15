package puzzle.ec.tkoa

import core.BaseSolution
import core.Puzzle
import core.PuzzleOrigin
import core.PuzzlePart

class Quest2: BaseSolution() {
    override val puzzle = Puzzle.THE_KINGDOM_OF_ALGORITHMIA
    override val day = 2
    override val origin = PuzzleOrigin.EVERYBODY_CODES

    override fun getParts(): List<PuzzlePart> {
        return listOf(
            PuzzlePart(1, this::solvePart1),
            PuzzlePart(2, this::solvePart2),
            PuzzlePart(3, this::solvePart3)
        )
    }

    private fun solvePart1(input: List<String>) = input[2].split(" ").sumOf { word ->
        input[0].replace("WORDS:", "").split(",").count { word.contains(it) }
    }

    private fun solvePart2(input: List<String>) = input.drop(2).sumOf { line ->
        line.split(" ").sumOf { word ->
            input[0].replace("WORDS:", "").split(",").sumOf { runicWord ->
                runicWord.length * word.containsBothDirections(runicWord)
            }
        }
    }

    private fun solvePart3(input: List<String>): Int {
        return 0
    }

    private fun String.containsBothDirections(substring: String): Int {
        var count = 0
        if (this.contains(substring)) count++
        if (this.reversed().contains(substring)) count++
        return count
    }
}