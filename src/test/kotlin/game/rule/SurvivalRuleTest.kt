package game.rule

import game.DeadCell
import game.LiveCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test


class SurvivalRuleTest {

    private val rule = SurvivalRule()

    @Test
    fun `should not be applicable for dead cell`() {
        //when
        val applicable = rule.isApplicable(DeadCell, listOf(LiveCell, LiveCell))

        //then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and less than 2 live cells`() {
        //when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell))

        //then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for alive cell and more than 3 live cells`() {
        //when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell, LiveCell))

        //then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for alive cell and 2 live cells`() {
        //when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        //then
        applicable `should be` true
    }

    @Test
    fun `should be applicable for alive cell and 3 live cells`() {
        //when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        //then
        applicable `should be` true
    }

    @Test
    fun `nextState should be live`() {
        rule.nextState `should be` LiveCell
    }
}