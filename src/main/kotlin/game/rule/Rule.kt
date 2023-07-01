package game.rule

import game.Cell

interface Rule {
    val nextState: Cell
    fun isApplicable(cell: Cell, neighbors: List<Cell>): Boolean
}