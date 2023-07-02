import game.GameOfLife
import game.GamePattern
import game.GamePattern.DISAPPEARING
import game.GamePattern.GILDER
import game.GamePattern.REPEATABLE
import game.GamePattern.STABLE
import game.isAlive
import kotlin.system.exitProcess

private const val GRID_SIZE = 15

suspend fun main() {
    println("Hi, this is Game of Life!")
    val pattern = selectGamePattern()
    val game = GameOfLife(GRID_SIZE, pattern)
    game.print()
    game.play()
}

private fun selectGamePattern(): GamePattern {
    println(
        """
        Enter one of the game pattern names:
        
        glider 
        repeatable
        stable
        disappearing
        
        """.trimIndent()
    )
    return when (readlnOrNull()) {
        "glider" -> GILDER
        "repeatable" -> REPEATABLE
        "disappearing" -> DISAPPEARING
        "stable" -> STABLE
        else -> GILDER
    }
}

private fun GameOfLife.print() {
    val cells = this.getCells()
    cells.indices.forEach { rowIndex ->
        cells[rowIndex].indices.forEach { columnIndex ->
            print(if (cells[rowIndex][columnIndex].isAlive()) "|*" else "| ")
        }
        print("|")
        println()
    }
}

private suspend fun GameOfLife.play() {
    while (true) {
        printMenu()
        when (readlnOrNull()) {
            "next" -> {
                nextGeneration()
                print()
            }

            "reset" -> {
                val pattern = selectGamePattern()
                reset(GRID_SIZE, pattern)
                print()
            }

            "exit" -> exitProcess(0)
            else -> {
                println("Incorrect command")
                play()
            }
        }
    }
}

private fun printMenu() {
    println()
    println(
        """
           enter 'next' to generate Next generation;
           enter 'reset' to reset the game;
           enter 'exit' to exit;
        """.trimIndent()
    )
}