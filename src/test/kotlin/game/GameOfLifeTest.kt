package game

import game.GamePattern.GILDER
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class GameOfLifeTest {

    @Test
    fun `should return next generation of the game`() {
        // given
        val game = GameOfLife(5, GILDER)
        val expectedFirstGeneration = arrayOf(
            arrayOf(DeadCell, DeadCell, DeadCell, DeadCell, DeadCell),
            arrayOf(DeadCell, DeadCell, DeadCell, DeadCell, DeadCell),
            arrayOf(DeadCell, LiveCell, DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell, DeadCell, DeadCell)
        )

        // when
        runBlocking {
            game.nextGeneration()
        }

        // then
        val firstGeneration = game.getCells()
        firstGeneration.contentDeepEquals(expectedFirstGeneration) `should be` true
    }

    @Test
    fun `should reset the game to the initial state`() {
        // given
        val gridSize = 5
        val game = GameOfLife(gridSize, GILDER)
        val initGliderCells = game.getCells()

        // when
        runBlocking {
            repeat(3) { game.nextGeneration() }
        }
        val sellsAfterThreeTransitions = game.getCells()
        game.reset(gridSize, GILDER)
        val sellsAfterReset = game.getCells()

        // then
        initGliderCells.contentDeepEquals(sellsAfterThreeTransitions) `should be` false
        initGliderCells.contentDeepEquals(sellsAfterReset) `should be` true
    }
}