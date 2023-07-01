package game.rule

import game.LiveCell
import game.DeadCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class OvercrowdingRuleTest {

    private val rule = OvercrowdingRule()

    @Test
    fun `should not be applicable for dead cell`() {
        // when
        val applicable = rule.isApplicable(DeadCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and less than 3 alive neighbours`() {
        // when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and 3 alive neighbours`() {
        // when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for alive cell and more than 3 alive neighbours`() {
        // when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `nextState should be dead`() {
        rule.nextState `should be` DeadCell
    }
}