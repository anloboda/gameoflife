import game.GameOfLife
import game.GamePattern.GLIDER
import game.isAlive
import kotlin.system.exitProcess

fun main() {
    println("Hi, this is Game of Life!")
    val game = GameOfLife(15, GLIDER)
    println("Glider pattern board:")
    game.print()
    play(game)
}

fun play(game: GameOfLife) {
    while (true) {
        printMenu()
        when (readlnOrNull()) {
            "next" -> {
                game.nextGeneration()
                game.print()
            }

            "reset" -> {
                game.reset()
                game.print()
            }
            "exit" -> exitProcess(0)
            else -> {
                println("Incorrect command")
                play(game)
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