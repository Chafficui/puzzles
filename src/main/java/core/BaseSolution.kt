package core

abstract class BaseSolution :PuzzleSolution {
    protected fun createPart(number: Int, solution: (List<String>) -> Any): PuzzlePart = PuzzlePart(number, solution)
}