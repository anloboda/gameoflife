import game.GameOfLife
import game.GamePattern.GLIDER
import game.isAlive
import kotlin.system.exitProcess

fun main() {
    println("Hi, this is Game of Life!")
    val game = GameOfLife(5, GLIDER)
    println("Glider pattern board:")
    game.print()
    play(game)
}

fun play(game: GameOfLife) {
    while (true) {
        printMenu()
        when (readlnOrNull()) {
            "N" -> {
                game.nextGeneration()
                game.print()
            }

            "reset" -> game.reset()
            "exit" -> exitProcess(0);
            else -> play(game)
        }
    }
}

private fun printMenu() {
    println(
        """
           'N' to generate Next generation;
           'reset' to reset the game;
           'exit' to exit;
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


