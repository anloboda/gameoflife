package game.transition

import game.Cell

interface Transition {
    val nextGeneration: Cell
    fun isApplicable(cell: Cell, neighbors: List<Cell>): Boolean
}