package game.transition

import game.Cell
import game.LiveCell
import game.isAlive

private val survivalNeighborsRange = 2..3

class SurvivalTransition : Transition {
    override val nextState = LiveCell

    override fun isApplicable(cell: Cell, neighbors: List<Cell>) =
        cell.isAlive() && neighbors.count(Cell::isAlive) in survivalNeighborsRange
}