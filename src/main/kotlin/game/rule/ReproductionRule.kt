package game.rule

import game.Cell
import game.LiveCell
import game.isAlive
import game.isDead

private const val REPRODUCTION_NEIGHBORS_COUNT = 3

class ReproductionRule : Rule {
    override val nextState = LiveCell

    override fun isApplicable(cell: Cell, neighbors: List<Cell>) =
        cell.isDead() && neighbors.count(Cell::isAlive) == REPRODUCTION_NEIGHBORS_COUNT
}