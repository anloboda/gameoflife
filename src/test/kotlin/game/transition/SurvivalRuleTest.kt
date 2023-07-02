package game.transition

import game.DeadCell
import game.LiveCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class SurvivalRuleTest {

    private val survivalTransition = SurvivalTransition()

    @Test
    fun `should not be applicable for dead cell`() {
        // when
        val applicable = survivalTransition.isApplicable(DeadCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and less than 2 alive neighbors`() {
        // when
        val applicable = survivalTransition.isApplicable(LiveCell, listOf(LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and more than 3 alive neighbors`() {
        // when
        val applicable = survivalTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for alive cell and 2 alive neighbors`() {
        // when
        val applicable = survivalTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `should be applicable for alive cell and 3 alive neighbors`() {
        // when
        val applicable = survivalTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `nextState should be live`() {
        survivalTransition.nextGeneration `should be` LiveCell
    }
}