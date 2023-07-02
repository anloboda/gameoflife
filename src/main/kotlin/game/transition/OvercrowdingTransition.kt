package game.transition

import game.Cell
import game.DeadCell
import game.isAlive

private const val OVERCROWDING_NEIGHBORS_COUNT = 3

object OvercrowdingTransition : Transition {
    override val nextGeneration = DeadCell

    override fun isApplicable(cell: Cell, neighbors: List<Cell>) =
        cell.isAlive() && neighbors.count(Cell::isAlive) > OVERCROWDING_NEIGHBORS_COUNT
}