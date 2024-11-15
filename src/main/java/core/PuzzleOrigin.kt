package core

enum class PuzzleOrigin {
    ADVENT_OF_CODE,
    EVERYBODY_CODES;

    fun getDefaultPartsCount(): Int = when (this) {
        ADVENT_OF_CODE -> 2
        EVERYBODY_CODES -> 3
    }
}