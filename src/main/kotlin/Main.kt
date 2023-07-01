import game.GameOfLife
import game.GamePattern
import game.GamePattern.DISAPPEARING
import game.GamePattern.GILDER
import game.GamePattern.REPEATABLE
import game.GamePattern.STABLE
import game.isAlive
import kotlin.system.exitProcess

fun main() {
    println("Hi, this is Game of Life!")
    val pattern = selectGamePattern()
    val game = GameOfLife(15, pattern)
    game.print()
    game.play()
}

private fun selectGamePattern(): GamePattern {
    println(
        """
        Enter the name of the game pattern:
        
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

private fun GameOfLife.play() {
    while (true) {
        printMenu()
        when (readlnOrNull()) {
            "next" -> {
                nextGeneration()
                print()
            }

            "reset" -> {
                val pattern = selectGamePattern()
                reset(pattern)
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