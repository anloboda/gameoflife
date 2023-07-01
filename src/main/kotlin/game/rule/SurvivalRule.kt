package game.rule

import game.Cell
import game.LiveCell
import game.isAlive

private val survivalNeighborsRange = 2..3

//Any live cell with two or three live neighbors lives on to the next generation.
class SurvivalRule : Rule {
    override val nextState = LiveCell

    override fun isApplicable(cell: Cell, neighbors: List<Cell>) =
        cell.isAlive() && neighbors.count(Cell::isAlive) in survivalNeighborsRange
}