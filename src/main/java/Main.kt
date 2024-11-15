import core.Puzzle
import core.PuzzleRunner
import puzzle.ec.tkoa.Quest1
import puzzle.ec.tkoa.Quest2
import java.io.File

val solutions = listOf(
    Quest1(),
    Quest2()
)

fun main() {
    val runner = PuzzleRunner()
    solutions.forEach { runner.runSolution(it) }

    generateREADME()
}

fun generateREADME() {
    val readme = StringBuilder().apply {
        append("# Kotlin Solutions by Felix Beinßen\n\n")
        append("This is my collection of solutions to coding puzzles from various sources. The solutions are written in Kotlin and are tested against the provided test cases. They are no where near perfect, but they work for the given input.\n\n")


        solutions.groupBy { it.origin }.forEach { (origin, originSolutions) ->
            append("## ${origin.getLongName()}\n\n")

            // Create header with all puzzles
            val allPuzzles = Puzzle.entries.toTypedArray()
            append("|Day|")
            append(allPuzzles.joinToString("|") { it.getLongName() })
            append("|\n")

            // Separator line
            append("|---|")
            append(allPuzzles.joinToString("|") { "---" })
            append("|\n")

            // Get all implemented days
            val implementedSolutions = originSolutions.groupBy { it.day to it.puzzle }

            // For each possible day (1 to max day count among all puzzles)
            (1..allPuzzles.maxOf { it.getDayCount() }).forEach { day ->
                append("|$day|")
                append(allPuzzles.joinToString("|") { puzzle ->
                    val solution = implementedSolutions[day to puzzle]?.firstOrNull()
                    if (solution != null) {
                        val packagePath = solution::class.qualifiedName?.substringBeforeLast('.')
                        val className = solution::class.simpleName
                        val filePath = "src/main/java/${packagePath?.replace('.', '/')}/$className.kt"
                        "[✅]($filePath)"
                    } else {
                        "❌"
                    }
                })
                append("|\n")
            }
            append("\n")
        }
    }

    File("README.md").writeText(readme.toString())
}