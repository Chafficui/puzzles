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
            append("## $origin\n\n")

            originSolutions.groupBy { it.puzzle }.toSortedMap().forEach { (year, yearSolutions) ->
                append("### $year\n\n")

                val partCount = yearSolutions.first().getParts().size
                append((1..partCount).joinToString("|", prefix = "|Day|", postfix = "|\n") { "Part $it" })
                append((1..partCount).joinToString("|", prefix = "|---|", postfix = "|\n") { "---" })

                yearSolutions.groupBy { it.day }
                    .toSortedMap()
                    .forEach { (day, daySolutions) ->
                        val solution = daySolutions.first()
                        val packagePath = solution::class.qualifiedName?.substringBeforeLast('.')
                        val className = solution::class.simpleName

                        append("|$day|")
                        append(solution.getParts().joinToString("|") { part ->
                            "[Solution](src/main/java/${packagePath?.replace('.', '/')}/$className.kt)"
                        })
                        append("|\n")
                    }
                append("\n")
            }
        }
    }

    File("README.md").writeText(readme.toString())
}