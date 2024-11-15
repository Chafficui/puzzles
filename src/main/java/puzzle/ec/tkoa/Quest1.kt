package puzzle.ec.tkoa

import core.BaseSolution
import core.PuzzleOrigin
import core.PuzzlePart

class Quest1() : BaseSolution() {
    override val puzzle = "The Kingdom of Algorithmia"
    override val day = 1
    override val origin = PuzzleOrigin.EVERYBODY_CODES
    override fun getParts(): List<PuzzlePart> {
        return listOf(
            PuzzlePart(1, this::solvePart1),
            PuzzlePart(2, this::solvePart2),
            PuzzlePart(3, this::solvePart3)
        )
    }

    private fun solvePart1(input: List<String>): Int {
        var result = 0
        input[0].toCharArray().forEach {
            result += when(it) {
                'B' -> 1
                'C' -> 3
                else -> 0
            }
        }
        return result
    }

    private fun solvePart2(input: List<String>): Int {
        var result = 0
        input[0].chunked(2).forEach { chunk ->
            val extraPerCreature = if (!chunk.contains("x")) 1 else 0

            chunk.toCharArray().forEach { creature ->
                result += when(creature) {
                    'B' -> 1 + extraPerCreature
                    'C' -> 3 + extraPerCreature
                    'D' -> 5 + extraPerCreature
                    'A' -> extraPerCreature
                    else -> 0
                }
            }
        }
        return result
    }

    private fun solvePart3(input: List<String>): Int {
        var result = 0
        input[0].chunked(3).forEach { chunk ->
            val extraPerCreature = when(chunk.count { it == 'x' }) {
                0 -> 2
                1 -> 1
                else -> 0
            }

            chunk.toCharArray().forEach { creature ->
                result += when(creature) {
                    'B' -> 1 + extraPerCreature
                    'C' -> 3 + extraPerCreature
                    'D' -> 5 + extraPerCreature
                    'A' -> extraPerCreature
                    else -> 0
                }
            }
        }
        return result
    }
}