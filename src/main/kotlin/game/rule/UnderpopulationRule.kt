package game.rule

import game.Cell
import game.DeadCell
import game.isAlive

private const val UNDERPOPULATION_NEIGHBORS_COUNT = 2

// Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
class UnderpopulationRule : Rule {
    override val nextState = DeadCell

    override fun isApplicable(cell: Cell, neighbors: List<Cell>) =
        cell.isAlive() && neighbors.count(Cell::isAlive) < UNDERPOPULATION_NEIGHBORS_COUNT
}