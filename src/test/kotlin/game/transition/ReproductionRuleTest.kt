package game.transition

import game.LiveCell
import game.DeadCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class ReproductionRuleTest {

    private val reproductionTransition = ReproductionTransition()

    @Test
    fun `should not be applicable for alive cell`() {
        // when
        val applicable = reproductionTransition.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for dead cell and less than 3 live neighbors`() {
        // when
        val applicable = reproductionTransition.isApplicable(DeadCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for dead cell and more than 3 live neighbors`() {
        // when
        val applicable = reproductionTransition.isApplicable(DeadCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for dead cell and 3 live neighbors`() {
        // when
        val applicable = reproductionTransition.isApplicable(DeadCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `next state should be live`() {
        reproductionTransition.nextState `should be` LiveCell
    }
}