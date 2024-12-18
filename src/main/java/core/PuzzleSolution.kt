package core

interface PuzzleSolution {
    val day: Int
    val puzzle: Puzzle
    val origin: PuzzleOrigin

    fun getParts(): List<PuzzlePart>

    fun parseInput(input: List<String>): List<String> = input
    fun validate(input: List<String>): Boolean = true
}