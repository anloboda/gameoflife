package game

import org.amshove.kluent.`should contain all`
import org.junit.jupiter.api.Test

class GameOfLifeTest {

    @Test
    fun `should return next generation of the game`() {
        // given
        val game = GameOfLife(5, GamePattern.GLIDER)

        // when
        game.nextGeneration()

        // then
        val nextGeneration = game.getCells()
        nextGeneration[0].`should contain all`(arrayOf(DeadCell, DeadCell, DeadCell, DeadCell, DeadCell))
        nextGeneration[1].`should contain all`(arrayOf(DeadCell, DeadCell, DeadCell, DeadCell, DeadCell))
        nextGeneration[2].`should contain all`(arrayOf(DeadCell, LiveCell, DeadCell, LiveCell, DeadCell))
        nextGeneration[3].`should contain all`(arrayOf(DeadCell, DeadCell, LiveCell, LiveCell, DeadCell))
        nextGeneration[4].`should contain all`(arrayOf(DeadCell, DeadCell, LiveCell, DeadCell, DeadCell))
    }
}