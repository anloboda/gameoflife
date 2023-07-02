package game.transition

import game.DeadCell
import game.LiveCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class OvercrowdingTransitionTest {

    private val overcrowdingTransition = OvercrowdingTransition()

    @Test
    fun `should not be applicable for dead cell`() {
        // when
        val applicable = overcrowdingTransition.isApplicable(DeadCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and less than 3 alive neighbours`() {
        // when
        val applicable = overcrowdingTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and 3 alive neighbours`() {
        // when
        val applicable = overcrowdingTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for alive cell and more than 3 alive neighbours`() {
        // when
        val applicable = overcrowdingTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `nextGeneration should be dead`() {
        overcrowdingTransition.nextGeneration `should be` DeadCell
    }
}