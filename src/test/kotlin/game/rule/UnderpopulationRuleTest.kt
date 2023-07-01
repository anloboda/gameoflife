package game.rule

import game.DeadCell
import game.LiveCell
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class UnderpopulationRuleTest {

    private val rule = UnderpopulationRule()

    @Test
    fun `should not be applicable for live cell`() {
        // when
        val applicable = rule.isApplicable(DeadCell, listOf(LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for live cell and two live neighbors`() {
        // when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should not be applicable for live cell and more than two live neighbors`() {
        // when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell, LiveCell, LiveCell))

        // then
        applicable `should be` false
    }

    @Test
    fun `should be applicable for live cell and less than two live neighbors`() {
        // when
        val applicable = rule.isApplicable(LiveCell, listOf(LiveCell))

        // then
        applicable `should be` true
    }

    @Test
    fun `nextState should be dead`() {
        rule.nextState `should be` DeadCell
    }
}