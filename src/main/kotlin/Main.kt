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
            "exit" -> exitProcess(0);
            else -> play(game)
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
    cells.indices.forEach { i ->
        cells[i].indices.forEach { j ->
            print(if (cells[i][j].isAlive()) "|*" else "| ")
        }
        print("|")
        println()
    }
}


