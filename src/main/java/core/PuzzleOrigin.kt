package core

enum class PuzzleOrigin {
    ADVENT_OF_CODE,
    EVERYBODY_CODES;

    fun getLongName(): String = when (this) {
        ADVENT_OF_CODE -> "Advent of Code"
        EVERYBODY_CODES -> "Everybody Codes"
    }

    fun getShortName(): String = when (this) {
        ADVENT_OF_CODE -> "aoc"
        EVERYBODY_CODES -> "ec"
    }
}