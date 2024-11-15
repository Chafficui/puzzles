package core

import java.io.File
import kotlin.system.measureTimeMillis

class PuzzleRunner {
    fun runSolution(solution: PuzzleSolution, inputFilePath: String? = null) {

        println("Running ${solution.origin} ${solution.puzzle} Day ${solution.day}")
        println("----------------------------------------")

        solution.getParts().forEach { part ->
            val input = loadInput(solution, part.number, inputFilePath)

            if (!solution.validate(input)) {
                println("Input validation failed for ${solution.origin} ${solution.puzzle} Day ${solution.day}")
                return
            }

            val parsedInput = solution.parseInput(input)
            var result: Any

            val timeMs: Long = measureTimeMillis {
                result = part.solution(parsedInput)
            }
            println("Part ${part.number} Result: $result (completed in $timeMs ms)")
        }
        println("----------------------------------------")
    }

    private fun loadInput(solution: PuzzleSolution, part: Int, customInputPath: String? = null): List<String> {
        val inputFile = when {
            customInputPath != null -> File(customInputPath)
            else -> getDefaultInputFile(solution, part)
        }

        return if (inputFile.exists()) {
            inputFile.readLines()
        } else {
            println("Input file not found: ${inputFile.absolutePath}")
            emptyList()
        }
    }

    private fun getDefaultInputFile(solution: PuzzleSolution, part: Int): File {
        val baseDir = solution.origin.getShortName()

        return File("src/main/resources/$baseDir/${solution.puzzle.getShortName()}/day${solution.day.toString().padStart(2, '0')}-${part}.txt")
    }
}