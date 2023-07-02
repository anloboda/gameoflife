package game.transition

import game.DeadCell
import game.LiveCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class UnderpopulationTransitionTest {

    @Test
    fun `should not be applicable for alive cell`() {
        // when
        val applicable = UnderpopulationTransition.isApplicable(DeadCell, listOf(LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and two alive neighbors`() {
        // when
        val applicable = UnderpopulationTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and more than two alive neighbors`() {
        // when
        val applicable = UnderpopulationTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for alive cell and less than two alive neighbors`() {
        // when
        val applicable = UnderpopulationTransition.isApplicable(LiveCell, listOf(LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `nextGeneration should be dead`() {
        UnderpopulationTransition.nextGeneration `should be` DeadCell
    }
}