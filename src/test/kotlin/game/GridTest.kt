package game

import game.GamePattern.GILDER
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class GridTest {

    private val grid = Grid(5, GILDER)

    @Test
    fun `getNeighbors() should return 8 neighbors when cell is in the center`() {
        // when
        val neighbors = grid.getNeighbors(1, 2)

        // then
        neighbors.size `should be equal to` 8
        neighbors `should be equal to` listOf(
            DeadCell,
            DeadCell,
            DeadCell,
            DeadCell,
            DeadCell,
            DeadCell,
            DeadCell,
            LiveCell
        )
    }

    @Test
    fun `getNeighbors() should return 3 neighbors when cell is in the left top corner`() {
        // when
        val neighbors = grid.getNeighbors(0, 0)

        // then
        neighbors.size `should be equal to` 3
        neighbors `should be equal to` listOf(
            DeadCell,
            DeadCell,
            DeadCell
        )
    }

    @Test
    fun `getNeighbors() should return 3 neighbors when cell is in the left bottom corner`() {
        // when
        val neighbors = grid.getNeighbors(4, 0)

        // then
        neighbors.size `should be equal to` 3
        neighbors `should be equal to` listOf(
            DeadCell,
            LiveCell,
            DeadCell
        )
    }

    @Test
    fun `getNeighbors() should return 3 neighbors when cell is in the right top corner`() {
        // when
        val neighbors = grid.getNeighbors(0, 4)

        // then
        neighbors.size `should be equal to` 3
        neighbors `should be equal to` listOf(
            DeadCell,
            DeadCell,
            DeadCell
        )
    }

    @Test
    fun `getNeighbors() should return 3 neighbors when cell is in the right bottom corner`() {
        // when
        val neighbors = grid.getNeighbors(4, 4)

        // then
        neighbors.size `should be equal to` 3
        neighbors `should be equal to` listOf(
            LiveCell,
            DeadCell,
            DeadCell
        )
    }

    @Test
    fun `getNeighbors() should return 5 neighbors when cell is in the top row`() {
        // when
        val neighbors = grid.getNeighbors(0, 2)

        // then
        neighbors.size `should be equal to` 5
        neighbors `should be equal to` listOf(
            DeadCell,
            DeadCell,
            DeadCell,
            LiveCell,
            DeadCell
        )
    }

    @Test
    fun `getNeighbors() should return 5 neighbors when cell is in the bottom row`() {
        // when
        val neighbors = grid.getNeighbors(4, 2)

        // then
        neighbors.size `should be equal to` 5
        neighbors `should be equal to` listOf(
            LiveCell,
            LiveCell,
            LiveCell,
            DeadCell,
            DeadCell
        )
    }

    @Test
    fun `getNeighbors() should return 5 neighbors when cell is in the first column`() {
        // when
        val neighbors = grid.getNeighbors(2, 0)

        // then
        neighbors.size `should be equal to` 5
        neighbors `should be equal to` listOf(
            DeadCell,
            DeadCell,
            DeadCell,
            DeadCell,
            LiveCell
        )
    }

    @Test
    fun `getNeighbors() should return 5 neighbors when cell is in the last column`() {
        // when
        val neighbors = grid.getNeighbors(2, 4)

        // then
        neighbors.size `should be equal to` 5
        neighbors `should be equal to` listOf(
            DeadCell,
            DeadCell,
            LiveCell,
            LiveCell,
            DeadCell
        )
    }
}