package game

import game.GamePattern.GLIDER
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class GameOfLifeTest {

    @Test
    fun `should return next generation of the game`() {
        // given
        val game = GameOfLife(5, GLIDER)
        val expectedFirstGeneration = arrayOf(
            arrayOf(DeadCell, DeadCell, DeadCell, DeadCell, DeadCell),
            arrayOf(DeadCell, DeadCell, DeadCell, DeadCell, DeadCell),
            arrayOf(DeadCell, LiveCell, DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell, DeadCell, DeadCell)
        )

        // when
        game.nextGeneration()

        // then
        val firstGeneration = game.getCells()
        firstGeneration.contentDeepEquals(expectedFirstGeneration) `should be` true
    }

    @Test
    fun `should reset the game to the initial state`() {
        // given
        val game = GameOfLife(5, GLIDER)
        val initGliderCells = game.getCells()

        // when
        repeat(3) { game.nextGeneration() }
        val sellsAfterThreeTransitions = game.getCells()
        game.reset()
        val sellsAfterReset = game.getCells()

        // then
        initGliderCells.contentDeepEquals(sellsAfterThreeTransitions) `should be` false
        initGliderCells.contentDeepEquals(sellsAfterReset) `should be` true
    }
}