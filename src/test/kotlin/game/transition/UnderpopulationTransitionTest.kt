package game.transition

import game.DeadCell
import game.LiveCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class UnderpopulationTransitionTest {

    private val transition = UnderpopulationTransition()

    @Test
    fun `should not be applicable for alive cell`() {
        // when
        val applicable = transition.isApplicable(DeadCell, listOf(LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and two alive neighbors`() {
        // when
        val applicable = transition.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and more than two alive neighbors`() {
        // when
        val applicable = transition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for alive cell and less than two alive neighbors`() {
        // when
        val applicable = transition.isApplicable(LiveCell, listOf(LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `nextGeneration should be dead`() {
        transition.nextGeneration `should be` DeadCell
    }
}