package core

data class PuzzlePart (
    val number: Int,
    val solution: (List<String>) -> Any
)