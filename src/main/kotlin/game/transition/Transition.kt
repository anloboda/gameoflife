package game.transition

import game.Cell

sealed interface Transition {
    val nextGeneration: Cell
    fun isApplicable(cell: Cell, neighbors: List<Cell>): Boolean
}