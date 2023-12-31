package game.transition

import game.Cell
import game.LiveCell
import game.isAlive
import game.isDead

private const val REPRODUCTION_NEIGHBORS_COUNT = 3

object ReproductionTransition : Transition {
    override val nextGeneration = LiveCell

    override fun isApplicable(cell: Cell, neighbors: List<Cell>) =
        cell.isDead() && neighbors.count(Cell::isAlive) == REPRODUCTION_NEIGHBORS_COUNT
}