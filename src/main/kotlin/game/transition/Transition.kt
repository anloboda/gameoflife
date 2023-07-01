package game.transition

import game.Cell

interface Transition {
    val nextState: Cell
    fun isApplicable(cell: Cell, neighbors: List<Cell>): Boolean
}