package game

import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `isAlive() should be true for LiveCell`() {
        LiveCell.isAlive() `should be` true
    }

    @Test
    fun `isAlive() should be false for DeadCell`() {
        DeadCell.isAlive() `should be` false
    }

    @Test
    fun `isDead() should be false for LiveCell`() {
        LiveCell.isDead() `should be` false
    }

    @Test
    fun `isDead() should be true for DeadCell`() {
        DeadCell.isDead() `should be` true
    }
}